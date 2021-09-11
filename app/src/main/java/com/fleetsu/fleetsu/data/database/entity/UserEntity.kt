package com.fleetsu.fleetsu.data.database.entity

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class UserEntity(
    @PrimaryKey
    @SerializedName("userId") val userId: Int,
    @SerializedName("firstname") val firstName: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("avatarUrl") val avatarUrl: String
)