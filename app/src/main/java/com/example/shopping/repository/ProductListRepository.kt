package com.example.shopping.repository

import com.example.shopping.api.RetrofitService


class ProductListRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllProductList() = retrofitService.getAllProductList()
}