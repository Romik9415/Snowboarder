package com.fleetsu.fleetsu.di.modules

import com.fleetsu.fleetsu.ui.StartFragment
import com.fleetsu.fleetsu.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeStartFragment(): StartFragment

}