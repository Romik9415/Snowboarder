package com.fleetsu.fleetsu.di.modules

import com.fleetsu.fleetsu.di.AppViewModelsComponent
import com.fleetsu.fleetsu.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppViewModelsComponent::class])
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity
}