package com.fleetsu.fleetsu.di

import com.fleetsu.fleetsu.repositories.UserRepository
import com.fleetsu.fleetsu.ui.login.LoginViewModel
import dagger.Subcomponent

@Subcomponent
interface AppViewModelsComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): AppViewModelsComponent
    }

    fun provideViewModel(): LoginViewModel

}