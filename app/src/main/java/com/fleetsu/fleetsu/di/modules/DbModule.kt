package com.fleetsu.fleetsu.di.modules

import android.app.Application
import com.fleetsu.fleetsu.AppExecutors
import com.fleetsu.fleetsu.data.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun provideDatabase(app: Application, executors: AppExecutors): AppDatabase {
        return AppDatabase.getInstance(app, executors)
    }

}