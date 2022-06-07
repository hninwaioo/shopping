package com.za.sbs.delivery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TimeRequest : Serializable {

    @SerializedName("to")
    @Expose
    lateinit var to : String

    @SerializedName("from")
    @Expose
    lateinit var from : String

    override fun toString(): String {
        return "RemarkModel(to=$to, from=$from)"
    }
}