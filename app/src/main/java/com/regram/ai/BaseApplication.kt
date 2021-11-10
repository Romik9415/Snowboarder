package com.regram.ai

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.regram.ai.di.AppComponent
import com.regram.ai.di.initInjections
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var instance: BaseApplication
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = initInjections(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> =
        dispatchingInjector

    fun getInstance(): BaseApplication {
        return instance
    }

}
