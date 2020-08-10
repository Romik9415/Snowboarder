package com.fleetsu.fleetsu.di

import android.app.Application
import com.fleetsu.fleetsu.BaseApplication
import com.fleetsu.fleetsu.di.modules.*
import com.fleetsu.fleetsu.ui.login.modules.LoginActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*Global Component*/
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppViewModelsFactoryModule::class,
        DbModule::class,
        ExecutorsModule::class,
        RepositoriesModule::class,
        SpModule::class,
        NetworkModule::class,
        AppApiModule::class,

        //activities module
        LoginActivityModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}