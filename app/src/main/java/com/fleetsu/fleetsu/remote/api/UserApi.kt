package com.fleetsu.fleetsu.remote.api

import com.fleetsu.fleetsu.ui.discover.Meme
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("instalink/Parse")
    fun startLoadUserByUserNameAsync(
        @Body userBody: LoadUserDataToServerBody
    ): Deferred<List<Meme>>

    @GET("memes")
    fun getAllMemesAsync(): Deferred<List<Meme>>
}


data class LoadUserDataToServerBody(
    val username: String
)
//r.post('http://34.83.133.217/instalink/Parse', json={'username': 'oleksandr_bakhmach'}).content