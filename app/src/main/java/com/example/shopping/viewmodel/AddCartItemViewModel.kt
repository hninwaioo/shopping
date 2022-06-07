package com.example.shopping.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.example.shopping.model.AddCartItemModel

class AddCartItemViewModel(var application: Application): ViewModel()
{
    private val db:RoomSingleton = RoomSingleton.getInstance(application)
    internal val allCartItem : LiveData<List<AddCartItemModel>> = db.addCartItemDao().allCartItem()

    fun insert(addCartItemModel:AddCartItemModel){
        db.addCartItemDao().insert(addCartItemModel)
    }
}