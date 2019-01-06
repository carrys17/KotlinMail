package com.examples.shang.base.data.net

import com.examples.shang.base.common.BaseConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// 工厂模式, 单例
class RetrofitFactory private constructor(){

    companion object {
        // lazy也是线程安全的
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val interceptor:Interceptor

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()

        // 初始化一个拦截器，用于指定头部的拦截
        interceptor = Interceptor {
            chain ->
            val request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type","application/json")
                    .addHeader("charset","utf-8")
                    .build()
            chain.proceed(request)
        }

    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor) // 自己初始化的拦截器，headers相关的
                .addInterceptor(initLoggingInterceptor())
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build()
    }

    private fun initLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        //Logs request and response lines and their respective headers and bodies (if present)
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    // 创建service
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }


}
