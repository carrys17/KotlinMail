package com.example.shang.user.injection.module

import com.example.shang.user.service.UserService
import com.example.shang.user.service.impl.UserServiceImpl
import com.example.shang.user.service.impl.UserServiceImpl2
import dagger.Module
import dagger.Provides
import javax.inject.Named

// module可以看成是一个简单工厂，它提供实例化的方法，默认provides开头

@Module
class UserModule{


    @Provides
    @Named("service")
    fun providesUserService(service: UserServiceImpl):UserService{
        return service
    }

    @Provides
    @Named("service2")
    fun providesUserService2(service: UserServiceImpl2):UserService{
        return service
    }
}