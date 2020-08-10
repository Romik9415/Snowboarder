package com.fleetsu.fleetsu.di.modules

import com.fleetsu.fleetsu.remote.api.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppApiModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }
}