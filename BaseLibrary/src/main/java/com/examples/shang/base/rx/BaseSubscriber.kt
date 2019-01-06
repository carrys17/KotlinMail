package com.examples.shang.base.rx

import rx.Subscriber

// 基础的订阅者
open class BaseSubscriber<T>:Subscriber<T>() {
    override fun onNext(t: T) {

    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }
}