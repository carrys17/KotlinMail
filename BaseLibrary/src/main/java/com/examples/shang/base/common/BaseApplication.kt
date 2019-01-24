package com.examples.shang.base.common

import android.app.Application
import com.examples.shang.base.injection.component.AppComponent
import com.examples.shang.base.injection.component.DaggerAppComponent
import com.examples.shang.base.injection.module.AppModule

class BaseApplication : Application() {

    // 不能定为private，因为activity要用到
    lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        // 初始化component
        initAppInjection()
    }

    private fun initAppInjection() {
        applicationComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build();
    }
}