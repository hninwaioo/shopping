package com.example.room.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Register")
data class RegisterTableModel(

    @ColumnInfo(name = "reg_username")
    var Reg_Username: String,

    @ColumnInfo(name = "reg_email_phone")
    var Reg_email_phone : String,

    @ColumnInfo(name = "password")
    var Password: String,

    @ColumnInfo(name = "reg_confirm_password")
    var Reg_confirm_password : String

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userid")
    var userId: Int? = null
}