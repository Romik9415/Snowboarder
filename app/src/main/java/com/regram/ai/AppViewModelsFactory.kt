package com.regram.ai

import androidx.collection.ArrayMap
import androidx.lifecycle.ViewModel
import com.regram.ai.di.AppViewModelsComponent
import com.regram.ai.ui.login.LoginViewModel
import com.regram.ai.ui.main.UserViewModel
import java.util.concurrent.Callable

class AppViewModelsFactory(private val appViewModelsComponent: AppViewModelsComponent) :
    BaseViewModelFactory() {

    override fun fillViewModels(creators: ArrayMap<Class<*>, Callable<out ViewModel>>) {
        creators[LoginViewModel::class.java] = Callable { appViewModelsComponent.provideViewModel() }
        creators[UserViewModel::class.java] = Callable { appViewModelsComponent.provideUserViewModel() }
    }

}