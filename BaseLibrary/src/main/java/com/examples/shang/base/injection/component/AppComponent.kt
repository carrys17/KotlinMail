package com.examples.shang.base.injection.component

import android.content.Context
import com.examples.shang.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent{ // app级别的component，提供一个函数，暴露出全局的context
    fun context() : Context
}