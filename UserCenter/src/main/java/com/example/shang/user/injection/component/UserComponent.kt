package com.example.shang.user.injection.component

import com.example.shang.user.injection.module.UserModule
import com.example.shang.user.ui.activity.RegisterActivity
import dagger.Component

/**  component 注入器，连接目标和依赖实例的桥梁，它必须是一个接口或者抽象类
 *   将需要的module传入进来
 */

@Component(modules = arrayOf(UserModule::class))
interface UserComponent {

    // 指定注解到哪里，这里就是RegisterActivity
    fun inject(activity: RegisterActivity)
}