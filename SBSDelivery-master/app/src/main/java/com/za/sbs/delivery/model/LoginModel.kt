package com.za.sbs.delivery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginModel :Serializable{

    @SerializedName("email")
    @Expose
    lateinit var email : String

    @SerializedName("password")
    @Expose
    lateinit var password : String

    @SerializedName("latitude")
    @Expose
    var latitude : Double = 0.0

    @SerializedName("longitude")
    @Expose
    var longitude : Double = 0.0

    constructor(email: String, password: String, latitude : Double, longitude : Double) {
        this.email = email
        this.password = password
        this.latitude = latitude
        this.longitude = longitude
    }
}