package com.za.sbs.delivery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TicketsModel : Serializable {

    @SerializedName("id")
    @Expose
    var id : Int = 0

    @SerializedName("body")
    @Expose
    var body : String? = null

    @SerializedName("company_id")
    @Expose
    var company_id : Int = 0

    @SerializedName("label_id")
    @Expose
    var label_id : Int = 0

    @SerializedName("issuer_id")
    @Expose
    var issuer_id : Int = 0

    @SerializedName("issuer_name")
    @Expose
    var issuer_name : String? = null

    @SerializedName("type")
    @Expose
    var type : String? = null

    @SerializedName("status")
    @Expose
    var status : String? = null

    @SerializedName("deleted_at")
    @Expose
    var deleted_at : String? = null

    @SerializedName("created_at")
    @Expose
    var created_at : String? = null

    @SerializedName("updated_at")
    @Expose
    var updated_at : String? = null

    var solved: Boolean = false

    constructor(body: String, issuer_name: String, created_at: String, solved : Boolean) {
        this.body = body
        this.issuer_name = issuer_name
        this.created_at = created_at
        this.solved = solved
    }


    override fun toString(): String {

        return "TicketsModel(id=$id, body=$body, " +

                "company_id=$company_id, " +

                "label_id=$label_id, " +

                "issuer_id=$issuer_id, " +

                "issuer_name=$issuer_name, " +

                "type=$type, " +

                "status=$status, " +

                "deleted_at=$deleted_at, " +

                "created_at=$created_at, " +

                "updated_at=$updated_at, " +

                ")"
    }

}