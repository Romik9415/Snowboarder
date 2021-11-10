package com.regram.ai.di.modules

import android.app.Application
import com.regram.ai.data.sharedpreferences.SyncSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SpModule {

    @Singleton
    @Provides
    fun provideSyncSharedPreferences(app: Application): SyncSharedPreferences {
        return SyncSharedPreferences(app)
    }

}