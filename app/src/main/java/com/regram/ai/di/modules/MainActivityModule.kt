package com.regram.ai.di.modules

import com.regram.ai.di.AppViewModelsComponent
import com.regram.ai.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppViewModelsComponent::class])
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity
}