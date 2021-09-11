package com.fleetsu.fleetsu.ui.main

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @SerializedName("id") val id: Long,
    @SerializedName("userName")val userName: String
)
