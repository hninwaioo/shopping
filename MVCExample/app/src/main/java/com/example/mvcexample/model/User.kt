package com.example.mvcexample.model

import android.text.TextUtils
import android.util.Patterns

class User(override val email: String, override val password: String) : IUser {

    // 0. Check for Email Empty
    // 1. Check for Email Match pattern
    // 2. Check for Password > 6
    override val isValid: Int
        get() =// 0. Check for Email Empty
        // 1. Check for Email Match pattern
            // 2. Check for Password > 6
            if (TextUtils.isEmpty(email)) 0 else if (!Patterns.EMAIL_ADDRESS.matcher(
                    email
                ).matches()
            ) 1 else if (TextUtils.isEmpty(password)) 2 else if (password.length <= 6) 3 else -1

}