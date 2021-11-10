package com.regram.ai.di.modules

import com.regram.ai.AppExecutors
import com.regram.ai.data.AppDatabase
import com.regram.ai.remote.api.UserApi
import com.regram.ai.repositories.UserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideUserRepository(
        appDatabase: AppDatabase,
        appExecutors: AppExecutors,
        userApi: UserApi
    ): UserRepository {
        return UserRepository(appDatabase, appExecutors, userApi)
    }

}