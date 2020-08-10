package com.fleetsu.fleetsu.ui.login.modules

import com.fleetsu.fleetsu.di.AppViewModelsComponent
import com.fleetsu.fleetsu.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppViewModelsComponent::class])
abstract class LoginActivityModule {
    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    abstract fun contributeRecognitionActivity(): LoginActivity
}