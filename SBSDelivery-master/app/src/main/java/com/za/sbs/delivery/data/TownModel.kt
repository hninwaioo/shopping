package com.za.sbs.delivery.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TownModel (
    @SerializedName("id")
    var id : Int,

    @SerializedName("town")
    var town : Town,

    @SerializedName("region")
    var region : Region,

    @SerializedName("name_mm")
    var name_mm : String,

    @SerializedName("name_en")
    var name_en : String,

    @SerializedName("slug")
    var slug : String,

    @SerializedName("pcode")
    @Expose
    var pcode : String,

    @SerializedName("mp_post_code")
    @Expose
    var mp_post_code : String

)

data class Town(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("region_id")
    @Expose
    var region_id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String,

    @SerializedName("slug")
    @Expose
    var slug : String

)

data class Region(

    @SerializedName("id")
    var region_id : Int,

    @SerializedName("name_en")
    var region_name_en : String,

    @SerializedName("name_mm")
    var region_name_mm : String

)