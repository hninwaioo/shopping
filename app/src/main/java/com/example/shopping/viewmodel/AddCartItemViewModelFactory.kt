package com.example.shopping.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddCartItemViewModelFactory(var application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddCartItemViewModel::class.java)) {
            return AddCartItemViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}