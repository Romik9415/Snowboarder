package com.regram.ai.di

import com.regram.ai.ui.login.LoginViewModel
import com.regram.ai.ui.main.UserViewModel
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