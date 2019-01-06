package com.examples.shang.base.ext

import com.examples.shang.base.rx.BaseSubscriber
import rx.Observable

// 通用扩展方法类


// 扩展Observable的一个函数，名字为execute
fun <T> Observable<T>.execute(subscriber : BaseSubscriber<T>){
    this.subscribeOn(rx.schedulers.Schedulers.io()) // 订阅
            .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread()) // 观察
            .subscribe(subscriber)
}