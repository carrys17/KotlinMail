package com.example.shang.user.ui.activity

import android.os.Bundle
import com.example.shang.user.R
import com.example.shang.user.injection.component.DaggerUserComponent
import com.example.shang.user.injection.module.UserModule
import com.example.shang.user.presenter.RegisterPresenter
import com.example.shang.user.presenter.view.RegisterView
import com.examples.shang.base.ui.activity.BaseMVPActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(),RegisterView {

    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // 直接用xml的id，无需再去初始化控件，这种是kotlin-android-extensions的用法
        mRegisterBtn.setOnClickListener {
//            Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show()
            // anko commons的使用方式
//            toast("注册")
//            startActivity(intentFor<TestActivity>("id" to 2))
//            startActivity<TestActivity>("id" to 12)

//            mPresenter = RegisterPresenter()

            // 初始化注解
            initInjection()
            mPresenter.register(mPhoneEt.text.toString(),mPwdEt.text.toString(),mVerifyCodeEt.text.toString())
        }

    }

    private fun initInjection() {
        // 初始化一个Module，注入到this（也就是我们的activity中）
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }
}



