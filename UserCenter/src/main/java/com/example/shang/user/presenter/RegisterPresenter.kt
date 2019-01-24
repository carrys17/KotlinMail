package com.example.shang.user.presenter

import com.example.shang.user.presenter.view.RegisterView
import com.example.shang.user.service.UserService
import com.examples.shang.base.ext.execute
import com.examples.shang.base.presenter.BasePresenter
import com.examples.shang.base.rx.BaseSubscriber
import javax.inject.Inject
import javax.inject.Named

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    @field:[Named ("service")] // 这种写法是才是kotlin的，java中可以直接用@Named("service")
    lateinit var userService:UserService

    @Inject
    @field:[Named ("service2")] // 根据指定的名称来选择不同的实现方式
    lateinit var userService2:UserService

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

    fun register2(phone:String,pwd:String,verifyCode:String){
        /**
         * 业务逻辑
         */
//        val userService = UserServiceImpl()
        userService2.register(phone,pwd,verifyCode)
                .execute(object : BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })
    }
}