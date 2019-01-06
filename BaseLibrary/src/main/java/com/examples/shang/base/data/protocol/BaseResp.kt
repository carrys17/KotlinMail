package com.examples.shang.base.data.protocol

// 网络请求响应对象
class BaseResp<out T>(val status:Int,val message:String,val data:T)