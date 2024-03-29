package com.regram.ai.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.regram.ai.AppExecutors
import com.regram.ai.data.AppDatabase
import com.regram.ai.remote.api.LoadUserDataToServerBody
import com.regram.ai.remote.api.UserApi
import com.regram.ai.ui.discover.Meme
import com.regram.ai.ui.main.User
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

    suspend fun removeUser(user:User){
        appDatabase.userDao().delete(user)
    }

    suspend fun setUserToRepo(userString: String) {
        val body = LoadUserDataToServerBody(userString)
        val response = userApi.startLoadUserByUserNameAsync(body).await()
        val q = 11
    }

    suspend fun getUserByUserName(userName:String) : List<Meme>{
        val response = userApi.getAllMemesAsync(userName).await()
        val t = response
        return response
    }


}