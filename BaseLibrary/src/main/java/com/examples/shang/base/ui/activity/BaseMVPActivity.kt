package com.examples.shang.base.ui.activity

import com.examples.shang.base.presenter.BasePresenter
import com.examples.shang.base.presenter.view.BaseView
import javax.inject.Inject

open class BaseMVPActivity<T:BasePresenter<*>>:BaseActivity(),BaseView {

    @Inject
    lateinit var mPresenter: T

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }
}