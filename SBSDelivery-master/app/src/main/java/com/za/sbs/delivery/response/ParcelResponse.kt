package com.za.sbs.delivery.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.za.sbs.delivery.model.RemarkModel
import com.za.sbs.delivery.model.TicketsModel
import com.za.sbs.delivery.model.TimeRequest
import java.io.Serializable

data class ParcelResponse(

    @SerializedName("data")
    @Expose
    var data : ArrayList<LabelListResponse>,

    @SerializedName("links")
    @Expose
    var links: Links,

    @SerializedName("meta")
    @Expose
    var meta: Meta

)

data class ParcelData(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("accept_branch_id")
    @Expose
    var accept_branch_id: Int = 0,
    @SerializedName("accept_type")
    @Expose
    var accept_type: String,

    @SerializedName("company_id")
    @Expose
    var company_id: Int,
    @SerializedName("compensation_fee")
    @Expose
    var compensation_fee: CompensationFee,

    @SerializedName("created_at")
    @Expose
     var created_at: String,

    @SerializedName("creator_id")
    @Expose
    var creator_id: Int = 0,

    @SerializedName("creator_type")
    @Expose
     var creator_type: String,

    @SerializedName("deliver_branch_id")
    @Expose
    var deliver_branch_id: Int = 0,

    @SerializedName("destination_branch")
    @Expose
    var destination_branch : DestinationBranch,

    @SerializedName("destination_name")
    @Expose
     var destination_name: String,

    @SerializedName("destination_no")
    @Expose
     var destination_no: String,

    @SerializedName("destination_phone")
    @Expose
    var destination_phone: ArrayList<String>? = null,

    @SerializedName("destination_postcode")
    @Expose
     var destination_postcode: String,

    @SerializedName("destination_quarter")
    @Expose
     var destination_quarter: String,

    @SerializedName("destination_region")
    @Expose
     var destination_region: DestinationRegion,

    @SerializedName("destination_street")
    @Expose
    var destination_street: String,

    @SerializedName("destination_town")
    @Expose
    var destination_town: DestinationTown,

    @SerializedName("destination_township")
    @Expose
    var destination_township: DestinationTownship,

    @SerializedName("destination_address")
    @Expose
    var destination_address : String,

    @SerializedName("include_products")
    @Expose
     var include_products: String,

    @SerializedName("item_type")
    @Expose
     var item_type: String,

    @SerializedName("label_id")
    @Expose
     var label_id: String,

    @SerializedName("pickup_at_po")
    @Expose
    var pickup_at_po: Boolean = false,

    @SerializedName("purchase_type")
    @Expose
     var purchase_type: String,

    @SerializedName("rating_type")
    @Expose
     var rating_type: String,

    @SerializedName("service_type")
    @Expose
     var service_type: String,

    @SerializedName("services")
    @Expose
    var services: Services,

    @SerializedName("services_fee")
    @Expose
     var services_fee: Services_fee,

    @SerializedName("source_name")
    @Expose
     var source_name: String,

    @SerializedName("source_no")
    @Expose
     var source_no: String,

    @SerializedName("source_phone")
    @Expose
    var source_phone: ArrayList<String>? = null,

    @SerializedName("source_postcode")
    @Expose
     var source_postcode: String,

    @SerializedName("source_quarter")
    @Expose
     var source_quarter: String,

    @SerializedName("source_region")
    @Expose
     var source_region: SourceRegion,

    @SerializedName("source_town")
    @Expose
     var source_town: SourceTown,

    @SerializedName("source_street")
    @Expose
     var source_street: String,

    @SerializedName("source_township")
    @Expose
     var source_township: SourceTownship,

    @SerializedName("source_address")
    @Expose
    var source_address : String,

    @SerializedName("status")
    @Expose
     var status: String,

    @SerializedName("total_cost")
    @Expose
     var total_cost: String,

    @SerializedName("tracking_code")
    @Expose
     var tracking_code: String,

    @SerializedName("cod_code")
    @Expose
    var cod_code : String,

    @SerializedName("updated_at")
    @Expose
     var updated_at: String,

    @SerializedName("weight")
    @Expose
    var weight: Float = 0.0f,

    @SerializedName("flat")
    @Expose
     var flat: String,

    @SerializedName("transaction")
    @Expose
     var transaction: ArrayList<TransactionParcel>,

    @SerializedName("time_request")
    @Expose
     var time_request: TimeRequest,

    @SerializedName("remarks")
    @Expose
     var remarks: ArrayList<RemarkModel>,

    @SerializedName("tickets")
    @Expose
     var tickets: ArrayList<TicketsModel>

) : Serializable

data class CompensationFee(

    @SerializedName("compensation_fee")
    @Expose
    var compensation_fee : String
) : Serializable

data class Services(

    @SerializedName("cod")
    @Expose
    var cod : Boolean,

    @SerializedName("pod")
    @Expose
    var pod : Boolean,

    @SerializedName("sms")
    @Expose
    var sms : Boolean,

    @SerializedName("vfl")
    @Expose
    var vfl : Boolean,

    @SerializedName("shipping")
    @Expose
    var shipping : Boolean,

    @SerializedName("ops")
    @Expose
    var ops : Boolean,

    @SerializedName("flight")
    @Expose
    var flight : Boolean,

    @SerializedName("phone_call")
    @Expose
    var phone_call : Boolean,

    @SerializedName("pickup_service")
    @Expose
    var pickup_service : Boolean

) : Serializable

data class Services_fee(

    @SerializedName("za_fee")
    @Expose
    var za_fee : Int,

    @SerializedName("cod_fee")
    @Expose
    var cod_fee : Int,

    @SerializedName("pod_fee")
    @Expose
    var pod_fee : Int,

    @SerializedName("sms_fee")
    @Expose
    var sms_fee : Int,

    @SerializedName("tax_fee")
    @Expose
    var tax_fee : Int,

    @SerializedName("vfl_fee")
    @Expose
    var vfl_fee : Int,

    @SerializedName("return_fee")
    @Expose
    var return_fee : Int,

    @SerializedName("shipping_fee")
    @Expose
    var shipping_fee : Int,

    @SerializedName("hold_mail_fee")
    @Expose
    var hold_mail_fee : Int,

    @SerializedName("phone_call_fee")
    @Expose
    var phone_call_fee : Int,

    @SerializedName("cancellation_fee")
    @Expose
    var cancellation_fee : Int,

    @SerializedName("cash_collect_fee")
    @Expose
    var cash_collect_fee : Int,

    @SerializedName("postman_allowance")
    @Expose
    var postman_allowance : Int,

    @SerializedName("pickup_service_fee")
    @Expose
    var pickup_service_fee : Int,

    @SerializedName("change_destination_fee")
    @Expose
    var change_destination_fee : Int

) : Serializable

data class DestinationBranch(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en: String,

    @SerializedName("name_mm")
    @Expose
    var name_mm: String,

    @SerializedName("postcode")
    @Expose
    var postcode : String

)

data class DestinationRegion(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en: String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String

) : Serializable

data class DestinationTown(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en: String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String

//    @SerializedName("slug")
//    @Expose
//    var slug : String

) : Serializable

data class DestinationTownship(

    @SerializedName("id")
    @Expose
    var id : Int,

//    @SerializedName("town")
//    @Expose
//    var town : Town,
//
//    @SerializedName("region")
//    @Expose
//    var region : Region,

    @SerializedName("slug")
    @Expose
    var slug : String,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String

//    @SerializedName("pcode")
//    @Expose
//    var pcode : String,
//
//    @SerializedName("mp_post_code")
//    @Expose
//    var mp_post_code : String

) : Serializable

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
    @Expose
    var id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String
)

data class SourceRegion(
    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String
) : Serializable

data class SourceTown(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String

//    @SerializedName("slug")
//    @Expose
//    var slug : String
) : Serializable

data class SourceTownship(


    @SerializedName("id")
    @Expose
    var id : Int,


    @SerializedName("slug")
    @Expose
    var slug : String,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String

//    @SerializedName("pcode")
//    @Expose
//    var pcode : String,
//
//    @SerializedName("mp_post_code")
//    @Expose
//    var mp_post_code : String
) : Serializable

data class TransactionParcel(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("label_id")
    @Expose
    var label_id : Int,

    @SerializedName("status")
    @Expose
    var status: String,

    @SerializedName("tracking_code")
    @Expose
    var tracking_code : String,

//    @SerializedName("status")
//    @Expose
//    var status : String,

//    @SerializedName("remark")
//    @Expose
//    var remark : String,

//    @SerializedName("meta")
//    @Expose
//    var meta : String,

    @SerializedName("user")
    @Expose
    var user : User,

    @SerializedName("user_id")
    @Expose
    var user_id : Int,

    @SerializedName("viewable")
    @Expose
    var viewable : Boolean

//    @SerializedName("latitude")
//    @Expose
//    var latitude : String,
//
//    @SerializedName("longitude")
//    @Expose
//    var longitude : String,
//
//    @SerializedName("deleted_at")
//    @Expose
//    var deleted_at : String,
//
//    @SerializedName("created_at")
//    @Expose
//    var created_at : String,
//
//    @SerializedName("updated_at")
//    @Expose
//    var updated_at : String

) : Serializable

data class User(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("name")
    @Expose
    var name : String,

    @SerializedName("email")
    @Expose
    var email : String,

    @SerializedName("phones")
    @Expose
    var phones : ArrayList<String>,

    @SerializedName("nrc")
    @Expose
    var nrc : String,

    @SerializedName("start_date")
    @Expose
    var start_date : String,

    @SerializedName("gender")
    @Expose
    var gender : String,

    @SerializedName("default_locale")
    @Expose
    var default_locale : String,

    @SerializedName("dob")
    @Expose
    var dob : String,

    @SerializedName("marital_status")
    @Expose
    var marital_status : String,

    @SerializedName("staff_id")
    @Expose
    var staff_id : String,

    @SerializedName("generate_code")
    @Expose
    var generate_code : String,

    @SerializedName("role_id")
    @Expose
    var role_id : Int,

    @SerializedName("is_owner")
    @Expose
    var is_owner : Boolean,

    @SerializedName("company_id")
    @Expose
    var company_id : Int,

    @SerializedName("created_at")
    @Expose
    var created_at : String,

    @SerializedName("updated_at")
    @Expose
    var updated_at : String

) : Serializable

data class Links(

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
) : Serializable

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

) : Serializable

data class LabelListResponse(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("item_type")
    @Expose
    var item_type : String,

    @SerializedName("service_type")
    @Expose
    var service_type : String,

    @SerializedName("accept_type")
    @Expose
    var accept_type : String,

    @SerializedName("status")
    @Expose
    var status : String,

    @SerializedName("tracking_code")
    @Expose
    var tracking_code : String,

    @SerializedName("created_at")
    @Expose
    var created_at : String,

    @SerializedName("created_date")
    @Expose
    var created_date : String,

    @SerializedName("updated_at")
    @Expose
    var updated_at : String,

    @SerializedName("")
    @Expose
    var drop_post_office_at : String,

    @SerializedName("arrived_post_office_at")
    @Expose
    var arrived_post_office_at : String,

//    @SerializedName("destination_branch")
//    @Expose
//    var destination_branch : Destination_Branch,
//
//    @SerializedName("accept_branch")
//    @Expose
//    var accept_branch : Accept_branch? = null,
//
//    @SerializedName("source_branch")
//    @Expose
//    var source_branch : Source_branch,

    @SerializedName("source_name")
    @Expose
    var source_name : String,

    @SerializedName("source_township")
    @Expose
    var source_township : Source_Township,

    @SerializedName("destination_name")
    @Expose
    var destination_name : String,

    @SerializedName("destination_phone")
    @Expose
    var destination_phone : ArrayList<String>,

    @SerializedName("destination_address")
    @Expose
    var destination_address : String,

    @SerializedName("source_address")
    @Expose
    var source_address : String,

    @SerializedName("include_products")
    @Expose
    var include_products : String

)

data class Source_Township(

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("slug")
    @Expose
    var slug : String,

    @SerializedName("name_en")
    @Expose
    var name_en : String,

    @SerializedName("name_mm")
    @Expose
    var name_mm : String


)



