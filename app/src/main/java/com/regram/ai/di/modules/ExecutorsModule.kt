package com.regram.ai.di.modules

import com.regram.ai.AppExecutors
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