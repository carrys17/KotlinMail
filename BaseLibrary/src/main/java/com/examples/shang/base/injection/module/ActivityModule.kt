package com.examples.shang.base.injection.module

import android.app.Activity
import com.examples.shang.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

// activity级别的module
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun providesActivity():Activity{
        return activity;
    }
}