package com.fleetsu.fleetsu.di.modules

import com.fleetsu.fleetsu.AppViewModelsFactory
import com.fleetsu.fleetsu.di.AppViewModelsComponent
import dagger.Module
import dagger.Provides

@Module
class AppViewModelsFactoryModule {

    @Provides
    fun provideAppViewModelFactory(builder: AppViewModelsComponent.Builder): AppViewModelsFactory {
        return AppViewModelsFactory(builder.build())
    }

}