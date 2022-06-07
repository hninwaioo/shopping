package com.example.shopping.viewmodel
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.shopping.database.AddCartItemDao
import com.example.shopping.model.AddCartItemModel

@Database(entities = arrayOf(AddCartItemModel::class), version = 1, exportSchema = false)
abstract class RoomSingleton : RoomDatabase(){
    abstract fun addCartItemDao():AddCartItemDao

    companion object{
        private var INSTANCE: RoomSingleton? = null
        fun getInstance(context:Context): RoomSingleton{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    RoomSingleton::class.java,
                    "roomdb")
                    .build()
            }

            return INSTANCE as RoomSingleton
        }
    }
}