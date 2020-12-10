package com.fleetsu.fleetsu.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.fleetsu.fleetsu.AppExecutors
import com.fleetsu.fleetsu.data.AppDatabase
import com.fleetsu.fleetsu.data.database.We
import com.fleetsu.fleetsu.remote.api.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository
@Inject constructor(
    private val appDatabase: AppDatabase,
    private val appExecutors: AppExecutors,
    private val userApi: UserApi
) {
    val userLiveData = MediatorLiveData<We>()

    init {
//        userLiveData.addSource(appDatabase.userDao().getAllUsers()) {
//            if (it.any()) {
//                userLiveData.postValue(it.first())
//            }
//        }
    }

    fun getUser(lat: Double, lon: Double): LiveData<We> {
        getWeather(lat, lon)
        return userLiveData
    }

    private fun getWeather(
        lat: Double,
        lon: Double
    ) {
        val appid = "c8a8bcaf75b2d0531d7a11722635d53a"
        val call = userApi.getWeatherByCoordinates(lat, lon, appid)
        val callback = object : Callback<We> {
            override fun onResponse(call: Call<We>?, response: Response<We>?) {
                response?.body()?.let {
                    userLiveData.postValue(it)
                }
            }

            override fun onFailure(call: Call<We>?, t: Throwable?) {

            }
        }

        //make request
        call.enqueue(callback)
    }

}