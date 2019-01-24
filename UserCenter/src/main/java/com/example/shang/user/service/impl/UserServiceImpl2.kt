package com.example.shang.user.service.impl

import com.example.shang.user.data.repository.UserRepository
import com.example.shang.user.service.UserService
import rx.Observable
import javax.inject.Inject

class UserServiceImpl2 @Inject constructor():UserService {

    @Inject
    lateinit var repository:UserRepository

    override fun register(phone: String, pwd: String, verifyCode: String): Observable<Boolean> {
      return Observable.just(false) // 直接返回false,测试

//        val repository = UserRepository()
//        return repository.register(phone, pwd, verifyCode)
//                .flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
//                    override fun call(t: BaseResp<String>): Observable<Boolean> {
//                        if (t.status != 0){ // status不为0表示失败
//                            return Observable.error(BaseException(t.status,t.message))
//                        }
//                        return Observable.just(false)
//                    }
//
//                })

    }

}