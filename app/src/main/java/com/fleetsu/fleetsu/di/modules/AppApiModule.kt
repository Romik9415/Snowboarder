package com.fleetsu.fleetsu.di.modules

import com.fleetsu.fleetsu.remote.api.UserApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppApiModule {

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): UserApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(getBaseUri())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create(UserApi::class.java)
    }

    //Need to remove this fun
    private fun getBaseUri(): String {
        return "http://34.83.133.217/"
    }

    //    @Provides
    //    @Singleton
    //    fun reservationsApi(okHttpClient: OkHttpClient): ReservationsApi {
    //        val retrofit = Retrofit.Builder()
    //                .baseUrl(getBaseUri())
    //                .client(okHttpClient)
    //                .addConverterFactory(JacksonConverterFactory.create())
    //                .addCallAdapterFactory(CoroutineCallAdapterFactory())
    //                .build()
    //        return retrofit.create(ReservationsApi::class.java)
}