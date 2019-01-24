package com.example.shang.user.service

import rx.Observable

// 当userService有两个实现类时，为了区别使用哪个，就需要@qualifier

interface UserService {
    fun register(phone:String,verifyCode:String,pwd:String): Observable<Boolean>
}