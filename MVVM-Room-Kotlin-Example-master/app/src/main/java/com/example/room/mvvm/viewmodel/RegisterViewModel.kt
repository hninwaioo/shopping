package com.example.room.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room.mvvm.model.RegisterTableModel
import com.example.room.mvvm.repository.RegisterRepository

class RegisterViewModel : ViewModel() {
    var liveDataLogin: LiveData<RegisterTableModel>? = null

    fun insertUserData(context: Context, username: String, email_phone: String, password: String, confirm_password: String) {
        RegisterRepository.insertUserData(context, username, email_phone,password,confirm_password)
    }

    fun getRegisterDetails(context: Context, username: String) : LiveData<RegisterTableModel>? {
        liveDataLogin = RegisterRepository.getRegisterDetails(context, username)
        return liveDataLogin
    }
}