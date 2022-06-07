package com.za.sbs.delivery.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class BranchPostCodeResponse(
//    @SerializedName("date")
//    @Expose
//    var data: ArrayList<BranchPostCode>
//)

data class BranchPostCode(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String,

    @SerializedName("township_id")
    @Expose
    var township_id : Int,

    @SerializedName("postcode")
    @Expose
    var postcode : String,

    @SerializedName("label_en")
    @Expose
    var label_en : String,

    @SerializedName("label_mm")
    @Expose
    var label_mm : String,

    @SerializedName("region")
    @Expose
    var region : Region,

    @SerializedName("town")
    @Expose
    var town : Town,

    @SerializedName("township")
    @Expose
    var township : Township

)



