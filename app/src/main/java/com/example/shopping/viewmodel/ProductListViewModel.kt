package com.example.shopping.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.shopping.model.ProductModel
import com.example.shopping.repository.ProductListRepository

class ProductListViewModel(private val repository: ProductListRepository) : ViewModel() {

    val productsList = MutableLiveData<List<ProductModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllProductList() {

        val response = repository.getAllProductList()
        response.enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>) {
                productsList.postValue(response.body())

            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}