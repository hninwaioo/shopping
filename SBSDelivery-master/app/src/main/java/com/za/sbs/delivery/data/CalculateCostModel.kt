package com.za.sbs.delivery.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CalculateCostModel (

    @SerializedName("service_type")
    @Expose
    var service_type : String,

    @SerializedName("weight")
    @Expose
    var weight : Float,

    @SerializedName("destination_postcode")
    @Expose
    var destination_postcode : String,

    @SerializedName("item_type")
    @Expose
    var item_type : String,

    @SerializedName("cod_amount")
    @Expose
    var cod_amount : Int


)
