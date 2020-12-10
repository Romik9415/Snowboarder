package com.fleetsu.fleetsu.remote.api

import com.fleetsu.fleetsu.data.database.We
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("weather")
    fun getWeatherByCoordinates(
        @Query("lon") lon: Double,
        @Query("lat") lat: Double,
        @Query("appid") appid: String
    ): Call<We>
}