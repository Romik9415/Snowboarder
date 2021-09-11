package com.fleetsu.fleetsu.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.fleetsu.fleetsu.ui.main.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<User>>

//    @Query("SELECT * FROM user WHERE userId = :userId")
//    fun getUserById(userId: Int): LiveData<UserEntity>
//
//    @Query("DELETE FROM user WHERE userId = :userId")
//    fun deleteUserById(userId: Int)

}