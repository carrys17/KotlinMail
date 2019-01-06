package com.example.shang.user.service

import rx.Observable


interface UserService {
    fun register(phone:String,verifyCode:String,pwd:String): Observable<Boolean>
}