package com.za.sbs.delivery.response

import com.google.gson.annotations.SerializedName

data class ResponseCalculateFee (

    @SerializedName("shipping_fee") val shipping_fee :Float,
    @SerializedName("cod_fee") val cod_fee : Float
)