package com.regram.ai.di

import android.app.Application
import com.regram.ai.BaseApplication
import com.regram.ai.di.modules.*
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
        MainActivityModule::class
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