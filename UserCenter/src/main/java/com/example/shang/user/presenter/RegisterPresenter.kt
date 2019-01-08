package com.example.shang.user.presenter

import com.example.shang.user.presenter.view.RegisterView
import com.example.shang.user.service.UserService
import com.examples.shang.base.ext.execute
import com.examples.shang.base.presenter.BasePresenter
import com.examples.shang.base.rx.BaseSubscriber
import javax.inject.Inject

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService:UserService

    fun register(phone:String,pwd:String,verifyCode:String){
        /**
         * 业务逻辑
         */
//        val userService = UserServiceImpl()
        userService.register(phone,pwd,verifyCode)
                .execute(object : BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })
    }
}