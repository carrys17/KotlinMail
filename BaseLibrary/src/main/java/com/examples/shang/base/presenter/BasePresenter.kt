package com.examples.shang.base.presenter

import com.examples.shang.base.presenter.view.BaseView

open class BasePresenter<T:BaseView> {
    lateinit var mView:T
}