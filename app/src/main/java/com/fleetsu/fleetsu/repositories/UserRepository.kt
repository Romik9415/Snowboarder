package com.fleetsu.fleetsu.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.fleetsu.fleetsu.AppExecutors
import com.fleetsu.fleetsu.data.AppDatabase
import com.fleetsu.fleetsu.remote.api.LoadUserDataToServerBody
import com.fleetsu.fleetsu.remote.api.UserApi
import com.fleetsu.fleetsu.ui.discover.Meme
import com.fleetsu.fleetsu.ui.main.User
import javax.inject.Inject

class UserRepository
@Inject constructor(
    private val appDatabase: AppDatabase,
    private val appExecutors: AppExecutors,
    private val userApi: UserApi
) {
    val userLiveData = MediatorLiveData<List<User>>()

    fun getUsers(): LiveData<List<User>> {
        //getWeather(lat, lon)
        return appDatabase.userDao().getAllUsers()
    }

    suspend fun setUser(user: User) {
        appDatabase.userDao().insertData(user)
    }

    suspend fun setUserToRepo(userString: String) {
        val body = LoadUserDataToServerBody(userString)
        val response = userApi.startLoadUserByUserNameAsync(body).await()
        val q = 11
    }

    suspend fun getUserByUserName(userName:String) : List<Meme>{
        val response = userApi.getAllMemesAsync().await()
        val t = response
        return response
    }


}