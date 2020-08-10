package com.fleetsu.fleetsu.di.modules

import com.fleetsu.fleetsu.AppExecutors
import com.fleetsu.fleetsu.data.AppDatabase
import com.fleetsu.fleetsu.remote.api.UserApi
import com.fleetsu.fleetsu.repositories.UserRepository
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