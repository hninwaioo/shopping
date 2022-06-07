package com.example.room.mvvm.room

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room.mvvm.model.RegisterTableModel

interface RegisterDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertUserData(registerTableModel: RegisterTableModel)

    @Query("SELECT * FROM Login WHERE Username =:username")
    fun getRegisterUserDetails(username: String?) : LiveData<RegisterTableModel>
}