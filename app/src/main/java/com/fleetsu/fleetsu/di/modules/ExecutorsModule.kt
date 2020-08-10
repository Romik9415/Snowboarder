package com.fleetsu.fleetsu.di.modules

import com.fleetsu.fleetsu.AppExecutors
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ExecutorsModule {

    @Provides
    @Singleton
    fun provideAppExecutors(): AppExecutors {
        return AppExecutors(2)
    }

}