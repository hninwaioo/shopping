package com.example.room.mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.room.mvvm.model.RegisterTableModel
import com.example.room.mvvm.room.RegisterDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterRepository {
    companion object {

        var registerDatabase: RegisterDatabase? = null

        var registerTableModel: LiveData<RegisterTableModel>? = null

        fun initializeDB(context: Context) : RegisterDatabase {
            return RegisterDatabase.getDatabaseClient(context)
        }

        fun insertUserData(context: Context, username: String, email_phone: String, password:String, confirm_password:String) {

            registerDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                val loginDetails = RegisterTableModel(username, email_phone, password, confirm_password)
                registerDatabase!!.registerDatabaseDao().InsertUserData(loginDetails)
            }

        }

        fun getRegisterDetails(context: Context, username: String) : LiveData<RegisterTableModel>? {

            registerDatabase = initializeDB(context)

            registerTableModel = registerDatabase!!.registerDatabaseDao().getRegisterUserDetails(username)

            return registerTableModel
        }

    }

}