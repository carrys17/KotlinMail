package com.examples.shang.base.ui.activity

import com.examples.shang.base.presenter.BasePresenter
import com.examples.shang.base.presenter.view.BaseView

open class BaseMVPActivity<T:BasePresenter<*>>:BaseActivity(),BaseView {

    lateinit var mPresenter: T

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }
}