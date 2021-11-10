package com.regram.ai.remote.api

import com.regram.ai.ui.discover.Meme
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface UserApi {

    @POST("instalink/Parse")
    fun startLoadUserByUserNameAsync(
        @Body userBody: LoadUserDataToServerBody
    ): Deferred<List<Meme>>

    @GET("memes/{user_name}")
    fun getAllMemesAsync(
        @Path("user_name") userName: String
    ): Deferred<List<Meme>>
}


data class LoadUserDataToServerBody(
    val username: String
)
//r.post('http://34.83.133.217/instalink/Parse', json={'username': 'oleksandr_bakhmach'}).content