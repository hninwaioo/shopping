package com.za.sbs.delivery.response

import com.google.gson.annotations.SerializedName

data class ResponseLableCreate(

    @SerializedName("cod_amount")
    val codAmount: Int,

    @SerializedName("cost_description")
    val costDescription: CostDescription,

    @SerializedName("destination_name")
    val destinationName: String,

    @SerializedName("destination_no")
    val destinationNo: String,

    @SerializedName("destination_phone")
    val destinationPhone: List<String>,

    @SerializedName("destination_postcode")
    val destinationPostcode: String,

    @SerializedName("destination_quarter")
    val destinationQuarter: String,

    @SerializedName("destination_street")
    val destinationStreet: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("include_products_name")
    val includeProductsName: String,

    @SerializedName("include_products_quantity")
    val includeProductsQuantity: String,

    @SerializedName("item_type")
    val itemType: String,

    @SerializedName("pickup_at_po")
    val pickupAtPo: Boolean,

    @SerializedName("service_type")
    val serviceType: String,

    @SerializedName("total_cost")
    val totalCost: Int,

    @SerializedName("tracking_code")
    val trackingCode: String,

    @SerializedName("weight")
    val weight: String
)

data class CostDescription(

    @SerializedName("cod_fee")
    val codFee: Int,

    @SerializedName("shipping_fee")
    val shippingFee: Int
)