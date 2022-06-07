package com.za.sbs.delivery.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginResponse : Serializable {

    @SerializedName("user")
    @Expose
    var user : LoginUserResponse? = null

    @SerializedName("token")
    @Expose
    var token : String? = null


    override fun toString(): String {
        return "LoginResponse(user=$user, token=$token, " +

                ")"
    }
}

data class ResponseCode(

    @SerializedName("status")
    @Expose
    var status : Int,

//    @SerializedName("")
//    @Expose
    var loginresponse : LoginResponse,

//    @SerializedName("")
//    @Expose
    var errorsMessange : ErrorMessage
)

data class ErrorMessage(

    @SerializedName("messange")
    @Expose
    var message : String,

    @SerializedName("errors")
    @Expose
    var errors : Error
)

data class Error(

    @SerializedName("email")
    @Expose
    var email : ArrayList<String>
)