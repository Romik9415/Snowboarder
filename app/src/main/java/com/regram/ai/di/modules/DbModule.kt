package com.regram.ai.di.modules

import android.app.Application
import com.regram.ai.AppExecutors
import com.regram.ai.data.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun provideDatabase(app: Application, executors: AppExecutors): AppDatabase {
        return AppDatabase.getInstance(app, executors)
    }

}