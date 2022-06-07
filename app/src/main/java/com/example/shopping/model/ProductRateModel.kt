package com.example.shopping.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class ProductRating : Serializable{

    @SerializedName("rate")
    var rate : Float = 0.0f

    fun getProductRate(): Float {
        return rate
    }

    fun setProductRate(rate: Float) {
        this.rate = rate
    }

    @SerializedName("count")
    var count : Int = 0

    fun getProductCount(): Int {
        return count
    }

    fun setProductCount(count: Int) {
        this.count = count
    }
}