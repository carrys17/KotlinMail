package com.examples.shang.base.injection.component

import android.app.Activity
import com.examples.shang.base.injection.ActivityScope
import com.examples.shang.base.injection.module.ActivityModule
import dagger.Component


// application的component只有一个，而activity的有多个，所以给它们之间建立依赖关系
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun activity():Activity
}