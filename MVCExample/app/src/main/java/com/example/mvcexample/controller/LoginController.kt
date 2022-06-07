package com.example.mvcexample.controller

import com.example.mvcexample.View.ILoginView
import com.example.mvcexample.model.User

class LoginController(loginView: ILoginView) : ILoginController {
    var loginView: ILoginView
    override fun OnLogin(email: String?, password: String?) {
        val user = User(
            email!!,
            password!!
        )
        val loginCode = user.isValid
        if (loginCode == 0) {
            loginView.OnLoginError("Please enter Email")
        } else if (loginCode == 1) {
            loginView.OnLoginError("Please enter A valid Email")
        } else if (loginCode == 2) {
            loginView.OnLoginError("Please enter Password")
        } else if (loginCode == 3) {
            loginView.OnLoginError("Please enter Password greater the 6 char")
        } else {
            loginView.OnLoginSuccess("login Successful")
        }
    }

    init {
        this.loginView = loginView
    }
}