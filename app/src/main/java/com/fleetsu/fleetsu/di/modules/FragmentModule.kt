package com.fleetsu.fleetsu.di.modules

import com.fleetsu.fleetsu.ui.discover.DiscoverFragment
import com.fleetsu.fleetsu.ui.discover.ResortFragment
import com.fleetsu.fleetsu.ui.login.LoginFragment
import com.fleetsu.fleetsu.ui.main.MainFragment
import com.fleetsu.fleetsu.ui.main.OnBoardingPageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeStartFragment(): DiscoverFragment

    @ContributesAndroidInjector
    abstract fun contributeResortFragment(): ResortFragment

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeOnBoardingPageFragment(): OnBoardingPageFragment
}