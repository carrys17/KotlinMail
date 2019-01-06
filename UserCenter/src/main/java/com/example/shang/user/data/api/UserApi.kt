package com.example.shang.user.data.api

import com.example.shang.user.data.protocol.RegisterReq
import com.examples.shang.base.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {
    // 因为是retrofit，所以返回值就是一个Observable,它的类型是基础Resp<String>
    @POST("userCenter/register")
    fun register(@Body req:RegisterReq):Observable<BaseResp<String>>
}