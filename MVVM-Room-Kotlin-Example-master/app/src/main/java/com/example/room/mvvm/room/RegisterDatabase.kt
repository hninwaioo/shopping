package com.example.room.mvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.mvvm.model.RegisterTableModel

@Database(entities = arrayOf(RegisterTableModel::class), version = 1, exportSchema = false)
abstract class RegisterDatabase : RoomDatabase() {

    abstract fun registerDatabaseDao() : RegisterDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: RegisterDatabase? = null

        fun getDatabaseClient(context: Context) : RegisterDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, RegisterDatabase::class.java, "LOGIN_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}