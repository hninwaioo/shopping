package com.za.sbs.delivery.utils

import android.content.Context
import android.content.DialogInterface
import com.za.sbs.delivery.response.LoginResponse
import com.za.sbs.delivery.response.LoginUserResponse
import io.paperdb.Paper
import org.jetbrains.anko.*

fun readlogin (): LoginUserResponse?{

    return Paper.book().read<LoginUserResponse>("loginUser")
//    return Paper.book().read<LoginResponse>("loginUser")
//    return Paper.book().read("login")
}

fun savelogin(userlogResponse: LoginResponse?) {
    if (userlogResponse != null) {
        Paper.book().write("loginUser", userlogResponse.user)

        Paper.book().write("login",userlogResponse.token)
    }
}

fun Context.progressDialog(title: String): AlertBuilder<DialogInterface> {

    return alert {
        customView {
            linearLayout {
                padding = dip(30)
                progressBar { }

                textView {
                    padding = dip(10)
                    textSize = 20f
                    text = title
                }

            }
        }
    }
}