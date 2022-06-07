package com.za.sbs.delivery.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginUserResponse(

    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("gender")
    @Expose
    var gender: String,

    @SerializedName("company")
    @Expose
    var company: Company,

    @SerializedName("marital_status")
    @Expose
    var marital_status: String,

    @SerializedName("generate_code")
    @Expose
    var generate_code: String,

    @SerializedName("qr_code")
    @Expose
    var qr_code: String,

    @SerializedName("dob")
    @Expose
    var dob: String,

    @SerializedName("nrc")
    @Expose
    var nrc: String,

    @SerializedName("staff_id")
    @Expose
    var staff_id: String,

    @SerializedName("start_date")
    @Expose
    var start_date: String,

    @SerializedName("phones")
    @Expose
    var phones: ArrayList<String>?,

    @SerializedName("profile_picture")
    @Expose
    var profile_picture: String,

    @SerializedName("locale")
    @Expose
    var locale: String,

    @SerializedName("branch")
    @Expose
    var branch: Branch,

    @SerializedName("role")
    @Expose
    var role: Role?,

    @SerializedName("login_status")
    @Expose
    var login_status: ArrayList<LoginStatus>,

    @SerializedName("banned_at")
    @Expose
    var banned_at: String,

    @SerializedName("created_at")
    @Expose
    var created_at: String,

    @SerializedName("banks")
    @Expose
    var banks: ArrayList<String>,

    @SerializedName("website")
    @Expose
    var website: String,

    @SerializedName("facebook_page")
    @Expose
    var facebook_page: String,

    @SerializedName("address")
    @Expose
    var address: Address

) :Serializable

data class Company(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("phones")
    @Expose
    var phones: ArrayList<String>,

    @SerializedName("township")
    @Expose
    var township: String,

    @SerializedName("town")
    @Expose
    var town: String,

    @SerializedName("region")
    @Expose
    var region: String,

    @SerializedName("house_no")
    @Expose
    var house_no: String,

    @SerializedName("street")
    @Expose
    var street: String,

    @SerializedName("quarter")
    @Expose
    var quarter: String,

    @SerializedName("latitude")
    @Expose
    var latitude: String,

    @SerializedName("longitude")
    @Expose
    var longitude: String,

    @SerializedName("prefix_code")
    @Expose
    var prefix_code: String,

    @SerializedName("license_no")
    @Expose
    var license_no: String,

    @SerializedName("license_image")
    @Expose
    var license_image: String,

    @SerializedName("second_person")
    @Expose
    var second_person: SecondPerson,

    @SerializedName("deleted_at")
    @Expose
    var deleted_at: String,

    @SerializedName("created_at")
    @Expose
    var created_at: String,

    @SerializedName("updated_at")
    @Expose
    var updated_at: String

)

data class SecondPerson(
    @SerializedName("name")
    @Expose
    var name: String
)

data class Branch(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name_en")
    @Expose
    var name_en: String,

    @SerializedName("name_mm")
    @Expose
    var name_mm: String,

    @SerializedName("phones")
    @Expose
    var phones: ArrayList<String>,

    @SerializedName("company_id")
    @Expose
    var company_id: Int,

    @SerializedName("region_id")
    @Expose
    var region_id: Int,

    @SerializedName("town_id")
    @Expose
    var town_id: Int,

    @SerializedName("township_id")
    @Expose
    var township_id: Int,

    @SerializedName("sub_region")
    @Expose
    var sub_region: String,

    @SerializedName("no_en")
    @Expose
    var no_en: String,

    @SerializedName("no_mm")
    @Expose
    var no_mm: String,

    @SerializedName("street_en")
    @Expose
    var street_en: String,

    @SerializedName("street_mm")
    @Expose
    var street_mm: String,

    @SerializedName("quarter_en")
    @Expose
    var quarter_en: String,

    @SerializedName("quarter_mm")
    @Expose
    var quarter_mm: String,

    @SerializedName("postcode")
    @Expose
    var postcode: String,

    @SerializedName("additional_information_en")
    @Expose
    var additional_information_en: String,

    @SerializedName("additional_information_mm")
    @Expose
    var additional_information_mm: String,

    @SerializedName("status")
    @Expose
    var status: Boolean,

    @SerializedName("sms")
    @Expose
    var sms: Boolean,

    @SerializedName("emo")
    @Expose
    var emo: Boolean,

    @SerializedName("express")
    @Expose
    var express: Boolean,


//    @SerializedName("deleted_at")
//    @Expose
//    var deleted_at : String,

    @SerializedName("created_at")
    @Expose
    var created_at: String,

    @SerializedName("updated_at")
    @Expose
    var updated_at: String,

    @SerializedName("township_slug")
    @Expose
    var township_slug: String,

    @SerializedName("pivot")
    @Expose
    var pivot: Pivot

)

data class Pivot(
    @SerializedName("agent_id")
    @Expose
    var agent_id: Int,

    @SerializedName("branch_id")
    @Expose
    var branch_id: Int
)


data class Role(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: RoleName?,

    @SerializedName("slug")
    @Expose
    var slug: String,

    @SerializedName("permissions")
    @Expose
    var permissions: ArrayList<String>,

    @SerializedName("company_id")
    @Expose
    var company_id: String,

    @SerializedName("created_at")
    @Expose
    var created_at: String,

    @SerializedName("updated_at")
    @Expose
    var updated_at: String

)

data class RoleName(
    @SerializedName("en")
    @Expose
    var name_en: String,

    @SerializedName("mm")
    @Expose
    var name_mm: String
)

data class LoginStatus(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("user_id")
    @Expose
    var user_id: Int,

    @SerializedName("last_login")
    @Expose
    var last_login: String,

    @SerializedName("device")
    @Expose
    var device: String,

    @SerializedName("platform")
    @Expose
    var platform: String,

    @SerializedName("browser")
    @Expose
    var browser: String,

    @SerializedName("ip_address")
    @Expose
    var ip_address: String,

    @SerializedName("created_at")
    @Expose
    var created_at: String,

    @SerializedName("updated_at")
    @Expose
    var updated_at: String
)
//    @SerializedName("current_page")
//    @Expose
//    var current_page : Int,
//
//    @SerializedName("first_page_url")
//    @Expose
//    var first_page_url : String,
//
//    @SerializedName("from")
//    @Expose
//    var from : Int,
//
//    @SerializedName("last_page")
//    @Expose
//    var last_page : Int,
//
//    @SerializedName("last_page_url")
//    @Expose
//    var last_page_url : String,
//
//    @SerializedName("next_page_url")
//    @Expose
//    var next_page_url : String,
//
//    @SerializedName("path")
//    @Expose
//    var path : String,
//
//    @SerializedName("per_page")
//    @Expose
//    var per_page : Int,
//
//    @SerializedName("prev_page_url")
//    @Expose
//    var prev_page_url : String,
//
//    @SerializedName("to")
//    @Expose
//    var to : Int,
//
//    @SerializedName("total")
//    @Expose
//    var total : Int,
//
//    @SerializedName("data")
//    @Expose
//    var data : ArrayList<Data>


data class Data(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("user_id")
    @Expose
    var user_id: Int,

    @SerializedName("last_login")
    @Expose
    var last_login: String,

    @SerializedName("device")
    @Expose
    var device: String,

    @SerializedName("platform")
    @Expose
    var platform: String,

    @SerializedName("browser")
    @Expose
    var browser: String,

    @SerializedName("ip_address")
    @Expose
    var ip_address: String,

    @SerializedName("created_at")
    @Expose
    var created_at: String,

    @SerializedName("updated_at")
    @Expose
    var updated_at: String

)

data class Address(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("deleted_at")
    @Expose
    var deleted_at: String,

    @SerializedName("address_en")
    @Expose
    var address_en: String,

    @SerializedName("address_mm")
    @Expose
    var address_mm: String,

    @SerializedName("user_id")
    @Expose
    var user_id: Int,

    @SerializedName("town")
    @Expose
    var town: String,

    @SerializedName("township")
    @Expose
    var township: Int,

    @SerializedName("region")
    @Expose
    var region: String,

    @SerializedName("no_en")
    @Expose
    var no_en: String,

    @SerializedName("street_en")
    @Expose
    var street_en: String,

    @SerializedName("ward_en")
    @Expose
    var ward_en: String,

    @SerializedName("no_mm")
    @Expose
    var no_mm: String,

    @SerializedName("street_mm")
    @Expose
    var street_mm: String,

    @SerializedName("ward_mm")
    @Expose
    var ward_mm: String,

    @SerializedName("created_at")
    @Expose
    var created_at: String,

    @SerializedName("updated_at")
    @Expose
    var updated_at: String

)