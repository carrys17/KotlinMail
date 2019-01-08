package com.example.shang.user.data.repository

import com.example.shang.user.data.api.UserApi
import com.example.shang.user.data.protocol.RegisterReq
import com.examples.shang.base.data.net.RetrofitFactory
import com.examples.shang.base.data.protocol.BaseResp
import rx.Observable
import javax.inject.Inject

// 真正访问网络的类
class UserRepository @Inject constructor() {
    fun register(phone:String,pwd:String,verifyCode:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(phone, pwd, verifyCode))
    }
}