package com.fleetsu.fleetsu.remote.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface UserApi {

    @GET("getUser")
    fun getUser(): Call<ResponseBody>
}