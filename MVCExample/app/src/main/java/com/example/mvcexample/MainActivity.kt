package com.example.mvcexample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvcexample.controller.ILoginController
import com.example.mvcexample.controller.LoginController
import com.example.mvcexample.view.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {
    var email: EditText? = null
    var password: EditText? = null
    var loginb: Button? = null
    var loginPresenter: ILoginController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById<View>(R.id.email) as EditText
        password = findViewById<View>(R.id.password) as EditText
        loginb = findViewById<View>(R.id.loginb) as Button
        loginPresenter = LoginController(this)
        loginb!!.setOnClickListener {
            (loginPresenter as LoginController).OnLogin(
                email!!.text.toString().trim { it <= ' ' },
                password!!.text.toString().trim { it <= ' ' })
        }
    }

    override fun OnLoginSuccess(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun OnLoginError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}