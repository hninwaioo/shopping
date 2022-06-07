package com.za.sbs.delivery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CalculateFeeModel (

    @SerializedName("amount")
    @Expose
    var amount: Int,

    @SerializedName("type")
    @Expose
    var type : String
)