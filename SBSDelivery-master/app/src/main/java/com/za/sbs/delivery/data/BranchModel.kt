package com.za.sbs.delivery.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class BranchModel(

    @SerializedName("data")
    @Expose
    var data : ArrayList<BranchData>,

    @SerializedName("links")
    @Expose
    var links : Links,

    @SerializedName("meta")
    @Expose
    var meta: Meta
)

data class BranchData(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String,

    @SerializedName("phones")
    @Expose
    var phones : ArrayList<String>,

    @SerializedName("company_id")
    @Expose
    var company_id : Int,

    @SerializedName("region")
    @Expose
    var region: Region,

    @SerializedName("region_id")
    @Expose
    var region_id : Int,

    @SerializedName("town")
    @Expose
    var town: Town,

    @SerializedName("town_id")
    @Expose
    var town_id : Int,

    @SerializedName("township")
    @Expose
    var township : Township,

    @SerializedName("township_id")
    @Expose
    var township_id : Int,

    @SerializedName("township_slug")
    @Expose
    var township_slug : String,

    @SerializedName("no_en")
    @Expose
    var no_en : String,

    @SerializedName("no_mm")
    @Expose
    var no_mm : String,

    @SerializedName("street_en")
    @Expose
    var street_en : String,

    @SerializedName("street_mm")
    @Expose
    var street_mm : String,

    @SerializedName("quarter_en")
    @Expose
    var quarter_en : String,

    @SerializedName("quarter_mm")
    @Expose
    var quarter_mm : String,

    @SerializedName("company")
    @Expose
    var company : Company,

    @SerializedName("postcode")
    @Expose
    var postcode : String,

    @SerializedName("status")
    @Expose
    var status : Boolean,

    @SerializedName("cod")
    @Expose
    var cod : Boolean,

    @SerializedName("emo")
    @Expose
    var emo : Boolean,

    @SerializedName("sms")
    @Expose
    var sms : Boolean,

    @SerializedName("flight")
    @Expose
    var flight : Boolean,

    @SerializedName("express")
    @Expose
    var express : Boolean,

    @SerializedName("international_mail")
    @Expose
    var international_mail : Boolean,

    @SerializedName("additional_information_en")
    @Expose
    var additional_information_en : String,

    @SerializedName("additional_information_mm")
    @Expose
    var additional_information_mm : String,

    @SerializedName("private_mode")
    @Expose
    var private_mode : Boolean,

    @SerializedName("deleted")
    @Expose
    var deleted : Boolean,

    @SerializedName("log")
    @Expose
    var log : ArrayList<String>


)

data class Township(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("slug")
    @Expose
    var slug : String,

    @SerializedName("name_en")
    @Expose
    var name_en: String,

    @SerializedName("name_mm")
    @Expose
    var name_mm: String
)

data class Company(
    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name")
    @Expose
    var name : String,

    @SerializedName("phones")
    @Expose
    var phones : ArrayList<String>,

    @SerializedName("township")
    @Expose
    var township : String,

    @SerializedName("town")
    @Expose
    var town : String,

    @SerializedName("region")
    @Expose
    var region : String,

    @SerializedName("house_no")
    @Expose
    var house_no : String,

    @SerializedName("street")
    @Expose
    var street : String,

    @SerializedName("quarter")
    @Expose
    var quarter : String,

    @SerializedName("latitude")
    @Expose
    var latitude : String,

    @SerializedName("longitude")
    @Expose
    var longitude : String,

    @SerializedName("prefix_code")
    @Expose
    var prefix_code : String,

    @SerializedName("license_no")
    @Expose
    var license_no : String,

    @SerializedName("license_image")
    @Expose
    var license_image : String,

    @SerializedName("second_person")
    @Expose
    var second_person : SecondPerson,

    @SerializedName("deleted_at")
    @Expose
    var deleted_at : String,

    @SerializedName("created_at")
    @Expose
    var created_at : String,

    @SerializedName("updated_at")
    @Expose
    var updated_at : String

)

data class SecondPerson(
    @SerializedName("name")
    @Expose
    var name : String
)

data class Links (

    @SerializedName("first")
    @Expose
    var first : String,

    @SerializedName("last")
    @Expose
    var last : String,

    @SerializedName("prev")
    @Expose
    var prev : String,

    @SerializedName("next")
    @Expose
    var next : String
)

data class Meta(

    @SerializedName("current_page")
    @Expose
    var current_page : Int,

    @SerializedName("from")
    @Expose
    var from : Int,

    @SerializedName("last_page")
    @Expose
    var last_page : Int,

    @SerializedName("path")
    @Expose
    var path : String,

    @SerializedName("per_page")
    @Expose
    var per_page : Int,

    @SerializedName("to")
    @Expose
    var to : Int,

    @SerializedName("total")
    @Expose
    var total : Int


)