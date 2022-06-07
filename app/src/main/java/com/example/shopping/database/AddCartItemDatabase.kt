package com.example.shopping.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shopping.model.AddCartItemModel

@Database(entities = [AddCartItemModel::class], version = 1, exportSchema = false)
abstract class AddCartItemDatabase : RoomDatabase() {

    abstract val addCartItemDao: AddCartItemDao

    companion object {

        @Volatile
        private var INSTANCE: AddCartItemDatabase? = null


        fun getInstance(context: Context): AddCartItemDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AddCartItemDatabase::class.java,
                        "user_details_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}