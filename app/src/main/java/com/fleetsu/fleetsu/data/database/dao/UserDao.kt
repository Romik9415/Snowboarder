package com.fleetsu.fleetsu.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.fleetsu.fleetsu.ui.main.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<User>>

    @Delete
    suspend fun delete(user: User)


}