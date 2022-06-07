package com.example.shopping.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shopping.model.AddCartItemModel

@Dao
interface AddCartItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cartitem: AddCartItemModel?)

    @Query("SELECT * FROM cart_item ORDER BY id DESC")
    fun allCartItem(): LiveData<List<AddCartItemModel>>

//    @Insert
//    fun insertAllCartItem(users: List<AddCartItemModel>?)
//
//    @Update
//    fun update(note: AddCartItemModel?)
//
//    @Delete
//    fun delete(note: AddCartItemModel?)
//
//    @Query("DELETE FROM cart_item")
//    fun deleteAllCartItem()
//
//    @Query("SELECT * FROM cart_item ORDER BY priority DESC")
//    fun getAllCartItem(): LiveData<List<AddCartItemModel>>?
}