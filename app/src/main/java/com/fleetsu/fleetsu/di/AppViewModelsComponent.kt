package com.fleetsu.fleetsu.di

import com.fleetsu.fleetsu.ui.login.LoginViewModel
import com.fleetsu.fleetsu.ui.main.UserViewModel
import dagger.Subcomponent

@Subcomponent
interface AppViewModelsComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): AppViewModelsComponent
    }

    fun provideViewModel(): LoginViewModel
    fun provideUserViewModel(): UserViewModel

}