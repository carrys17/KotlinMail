package com.example.shang.user.injection.component

import com.example.shang.user.injection.module.UserModule
import com.example.shang.user.ui.activity.RegisterActivity
import com.examples.shang.base.injection.PerComponentScope
import com.examples.shang.base.injection.component.ActivityComponent
import dagger.Component

/**  component 注入器，连接目标和依赖实例的桥梁，它必须是一个接口或者抽象类
 *   将需要的module传入进来
 */



@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))// 在注册中添加依赖activity的component
interface UserComponent {

    // 指定注解到哪里，这里就是RegisterActivity
    fun inject(activity: RegisterActivity)
}