package com.za.sbs.delivery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RemarkModel : Serializable {

    @SerializedName("id")
    @Expose
    var id : Int = 0

    @SerializedName("remark")
    @Expose
    var remark : String? = null

    @SerializedName("created_at")
    @Expose
    var created_at : String? = null

    @SerializedName("updated_at")
    @Expose
    var updated_at : String? = null

    @SerializedName("author")
    @Expose
    var author : RemarkAuthor? = null

    //var name : String

    constructor(remark: String, name: String, created_at: String) {
        this.remark = remark
        this.author = RemarkAuthor(name)
        this.created_at = created_at

    }


    override fun toString(): String {

        return "RemarkModel(id=$id, " +

                "remark=$remark, " +

                "created_at=$created_at, " +

                "updated_at=$updated_at, " +

                "author=$author, " +

                ")"
    }
}

class RemarkAuthor : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    constructor(name : String) {
        this.name = name
    }

    override fun toString(): String {
        return "RemarkAuthor(id=$id, name=$name )"
    }
}
