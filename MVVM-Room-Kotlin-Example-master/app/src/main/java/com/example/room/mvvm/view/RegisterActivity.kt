package com.example.room.mvvm.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import com.example.room.mvvm.R
import com.example.room.mvvm.utils.InputValidation
import com.example.room.mvvm.viewmodel.LoginViewModel
import com.example.room.mvvm.viewmodel.RegisterViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity() {
    lateinit var registerViewModel: RegisterViewModel

    lateinit var context: Context

    private var inputValidation: InputValidation? = null

    private lateinit var Nested_scrollview : NestedScrollView

    private lateinit var Reg_username_layout : TextInputLayout
    private lateinit var Reg_gmail_layout : TextInputLayout
    private lateinit var Reg_password_layout : TextInputLayout
    private lateinit var Reg_confirm_password_layout : TextInputLayout

    private lateinit var Reg_username : TextInputEditText
    private lateinit var Reg_gmail : TextInputEditText
    private lateinit var Reg_password : TextInputEditText
    private lateinit var Reg_confirm_password : TextInputEditText

    private lateinit var Signup_Admin : AppCompatButton
    private lateinit var Login_admin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        context = this@RegisterActivity

        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

    }

    private fun initViews() {
        Nested_scrollview = findViewById<View>(R.id.nestedScrollView) as NestedScrollView
        Reg_username_layout = findViewById<View>(R.id.reg_username_layout) as TextInputLayout
        Reg_gmail_layout = findViewById<View>(R.id.reg_gmail_layout) as TextInputLayout
        Reg_password_layout =
            findViewById<View>(R.id.reg_password_layout) as TextInputLayout
        Reg_confirm_password_layout =
            findViewById<View>(R.id.reg_confirm_password_layout) as TextInputLayout

        Reg_username = findViewById<View>(R.id.regusername) as TextInputEditText
        Reg_gmail =
            findViewById<View>(R.id.reggmail) as TextInputEditText
        Reg_password =
            findViewById<View>(R.id.regpassword) as TextInputEditText
        Reg_confirm_password =
            findViewById<View>(R.id.regconfirmedpassword) as TextInputEditText
        Signup_Admin =
            findViewById<View>(R.id.signupadmin) as AppCompatButton
        Login_admin =
            findViewById<View>(R.id.login_btn) as TextView
    }


    private fun postDataToSQLite() {
        inputValidation = InputValidation(this)

        if (!inputValidation!!.isInputEditTextFilled(
                Reg_username,
                Reg_username_layout,
                getString(R.string.error_message_name)
            )
        ) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(
                Reg_gmail,
                Reg_gmail_layout,
                getString(R.string.error_message_email)
            )
        ) {
            return
        }
        if (!inputValidation!!.isInputEditTextEmail(
                Reg_gmail,
                Reg_gmail_layout,
                getString(R.string.error_message_email)
            )
        ) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(
                Reg_password,
                Reg_password_layout,
                getString(R.string.error_message_password)
            )
        ) {
            return
        }
        if (!inputValidation!!.isInputEditTextMatches(
                Reg_password, Reg_confirm_password,
                Reg_confirm_password_layout, getString(R.string.error_password_match)
            )
        ) {
            return
        }
        var username = Reg_username.text.toString().trim()
        var email_phone = Reg_gmail.text.toString().trim()
        var password = Reg_password.text.toString().trim()
        var confirm_password = Reg_confirm_password.toString().trim()
        registerViewModel.insertUserData(context,username,email_phone,password,confirm_password)
        Log.e("SuccessFull==>","Register")
//        lblInsertResponse.text = "Inserted Successfully"

//        registerViewModel.insertData(context, Reg_username.toString(), Reg_gmail.toString(),Reg_password.toString(),Reg_confirm_password.toString())
////        lblInsertResponse.text = "Inserted Successfully"
//        var get_gmail = Reg_gmail.text
//        Log.e("Get Gmail==>",get_gmail.toString())

//        uiScope.launch {
//
//            val user: RegisterEntity? =
//                registerDatabase?.registerDatabaseDao?.findByEmail(Reg_gmail.text.toString().trim())
//            if (user != null && user.getEmail()
//                    .equals(Reg_gmail.text.toString().trim())
////                Reg_gmail.getText().toString().trim()
//            ) {
//                user.setName(Reg_username.text.toString().trim())
//                user.setEmail(Reg_gmail.text.toString().trim())
//                user.setPassword(Reg_password.text.toString().trim())
//                uiScope.launch {
//                    registerDatabase?.registerDatabaseDao?.insertAll(user)
//
//                }
//                // Snack Bar to show success message that record saved successfully
//                Snackbar.make(
//                    Nested_scrollview,
//                    getString(R.string.success_message),
//                    Snackbar.LENGTH_LONG
//                ).show()
//                emptyInputEditText()
//            } else {
//
//                // Snack Bar to show error message that record already exists
//                Snackbar.make(
//                    Nested_scrollview,
//                    getString(R.string.error_email_exists),
//                    Snackbar.LENGTH_LONG
//                ).show()
//
//                Log.e("==>","Email Already exists")
//            }
//
//        }


    }


}