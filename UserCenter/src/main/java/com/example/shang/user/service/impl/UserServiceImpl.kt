package com.example.shang.user.service.impl

import com.example.shang.user.data.repository.UserRepository
import com.example.shang.user.service.UserService
import com.examples.shang.base.data.protocol.BaseResp
import com.examples.shang.base.rx.BaseException
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

class UserServiceImpl @Inject constructor():UserService {

    @Inject
    lateinit var repository:UserRepository

    override fun register(phone: String, pwd: String, verifyCode: String): Observable<Boolean> {
//      return Observable.just(true) // 直接返回true,测试

//        val repository = UserRepository()
        return repository.register(phone, pwd, verifyCode)
                .flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
                    override fun call(t: BaseResp<String>): Observable<Boolean> {
                        if (t.status != 0){ // status不为0表示失败
                            return Observable.error(BaseException(t.status,t.message))
                        }
                        return Observable.just(true)
                    }

                })

    }

}