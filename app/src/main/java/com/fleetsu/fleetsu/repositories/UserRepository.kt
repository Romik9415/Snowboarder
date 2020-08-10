package com.fleetsu.fleetsu.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.fleetsu.fleetsu.AppExecutors
import com.fleetsu.fleetsu.data.AppDatabase
import com.fleetsu.fleetsu.data.database.entity.UserEntity
import com.fleetsu.fleetsu.remote.api.UserApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class UserRepository
@Inject constructor(
    private val appDatabase: AppDatabase,
    private val appExecutors: AppExecutors,
    private val userApi: UserApi
) {
    val userLiveData = MediatorLiveData<UserEntity>()

    init {
        userLiveData.addSource(appDatabase.userDao().getAllUsers()) {
            if (it.any()) {
                userLiveData.postValue(it.first())
            }
        }
    }

    fun getUser(): LiveData<UserEntity> {
        loadUser()
        return userLiveData
    }

    private fun loadUser() {
        val call = userApi.getUser()
        val callback = object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                response?.body()?.let {
                    appExecutors.ioExecutor.execute {
                        UserEntity(
                            1, "aaaa", "bbbb",
                            "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2014/android.jpg"
                        ).also {
                            appDatabase.runInTransaction {
                                try {
                                    appDatabase.userDao().insertData(it)
                                } catch (ex: ConcurrentModificationException) {
                                    ex.printStackTrace()
                                }
                            }
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {

            }
        }

        //make request
        call.enqueue(callback)
    }

}