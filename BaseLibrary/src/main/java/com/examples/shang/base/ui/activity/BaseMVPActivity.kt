package com.examples.shang.base.ui.activity

import android.os.Bundle
import com.examples.shang.base.common.BaseApplication
import com.examples.shang.base.injection.component.ActivityComponent
import com.examples.shang.base.injection.component.DaggerActivityComponent
import com.examples.shang.base.injection.module.ActivityModule
import com.examples.shang.base.presenter.BasePresenter
import com.examples.shang.base.presenter.view.BaseView
import javax.inject.Inject

open class BaseMVPActivity<T:BasePresenter<*>>:BaseActivity(),BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
    }

}