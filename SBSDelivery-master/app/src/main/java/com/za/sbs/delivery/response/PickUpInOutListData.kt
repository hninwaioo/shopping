package com.za.sbs.delivery.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PickUpInOutListData : Serializable {

    @SerializedName("id")
    @Expose
    var id : Int = 0

//    @SerializedName("label")
//    @Expose
//    var label : Label? = null

    @SerializedName("transaction_status")
    @Expose
    var status : String? = null

    @SerializedName("status")
    @Expose
    var mstatus : String? = null

    @SerializedName("tracking_code")
    @Expose
    var tracking_code : String? = null

    @SerializedName("source")
    @Expose
    var source : String? = null

    @SerializedName("destination")
    @Expose
    var destination : String? = null

    @SerializedName("mailbag_id")
    @Expose
    var mailbag_id : Int = 0

    @SerializedName("letter_count")
    @Expose
    var letter_count : Int = 0

    @SerializedName("parcel_count")
    @Expose
    var parcel_count : Int = 0

    @SerializedName("total_weight")
    @Expose
    var total_weight : Float = 0.0f

    @SerializedName("type")
    @Expose
    var type : String? = null

    @SerializedName("creator")
    @Expose
    var creator : String? = null

    @SerializedName("created_at")
    @Expose
    var created_at : String? = null

    @SerializedName("created_date")
    @Expose
    var created_date : String? = null

//    @SerializedName("histories")
//    @Expose
//    var histories : ArrayList<Histories>? = null
//
//    @SerializedName("labels")
//    @Expose
//    var labels : ArrayList<Labels>? = null


}