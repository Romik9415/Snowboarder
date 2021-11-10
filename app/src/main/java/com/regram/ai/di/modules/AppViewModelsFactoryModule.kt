package com.regram.ai.di.modules

import com.regram.ai.AppViewModelsFactory
import com.regram.ai.di.AppViewModelsComponent
import dagger.Module
import dagger.Provides

@Module
class AppViewModelsFactoryModule {

    @Provides
    fun provideAppViewModelFactory(builder: AppViewModelsComponent.Builder): AppViewModelsFactory {
        return AppViewModelsFactory(builder.build())
    }

}