package com.fleetsu.fleetsu.ui.login.modules

import com.fleetsu.fleetsu.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFragment(): LoginFragment

}