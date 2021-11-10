package com.regram.ai.di.modules

import com.regram.ai.ui.discover.DiscoverFragment
import com.regram.ai.ui.login.OnBoardingFragment
import com.regram.ai.ui.main.MainFragment
import com.regram.ai.ui.onboarding.OnBoardingPageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): OnBoardingFragment

    @ContributesAndroidInjector
    abstract fun contributeStartFragment(): DiscoverFragment

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeOnBoardingPageFragment(): OnBoardingPageFragment
}