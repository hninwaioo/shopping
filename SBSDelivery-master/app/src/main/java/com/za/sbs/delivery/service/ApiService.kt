package com.za.sbs.delivery.service

import com.za.sbs.delivery.data.TownModel
import com.za.sbs.delivery.model.*
import com.za.sbs.delivery.response.*
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("api/login")
    fun LoginAccount(@Body loginModel: LoginModel): Observable<Response<LoginResponse>>

    @GET("api/location/townships")
    fun getTownship(@Header("Authorization") auth : String) : Observable<List<TownModel>>

//    @POST("api/label")
//    fun createLabelParcel(@Header("Authorization") auth : String ,@Body createModel: AgentCreateModel): Observable<Response<AgentCreateResponse>>
//
//    @POST("api/label/calculate_fees")
//    fun calculateCost(@Header("Authorization") auth : String,@Body calculateCostModel: CalculateCostModel): Observable<Int>//<CalculateCostResponse>>
//
//    @GET("api/label/searchByTrackingCode/{tracking_code}")
//    fun SearchTrackingCode(@Header("Authorization") auth : String,@Path("tracking_code") tracking_code: String): Observable<Response<ParcelData>>
//
//    @GET("api/label/acceptLabel")
//    fun getAcceptParcel(@Header("Authorization") auth : String,@Query("status") status: String, @Query("page"
//        ) page: Int): Observable<Response<ParcelResponse>>
//
//    @GET("api/label/{ID}")
//    fun getLabelDetail(@Header("Authorization") auth: String, @Path("ID") ID: Int) : Observable<Response<ParcelData>>
//
//    @GET("api/label/deliverLabel")
//    fun getDeliverParcel(@Header("Authorization") auth : String,@Query("status") status : String, @Query("page") page: Int) : Observable<Response<ParcelResponse>>
//
//    @POST("api/label/remark/{id}")
//    fun pendingParcelRemark(@Header("Authorization") auth : String,@Path("id") id : String, @Query("mobile") mobile : String, @Body pendingParcelRemarkModel: PendingParcelRemarkModel) : Observable<Response<RemarksResponse>>
//
//    //emo remark
//    @POST("api/emo/remark/{id}")
//    fun emoRemark(@Header("Authorization") auth: String,@Path("id") id : Int,@Query("mobile") mobile : String, @Body pendingParcelRemarkModel: PendingParcelRemarkModel) : Observable<Response<RemarksResponse>>
//
//    @POST("api/label/{id}/change_status")
//    fun reasonforSendBack(@Header("Authorization") auth : String,@Path("id") id: String, @Body remarkDeliverChangeStatusModel: RemarkDeliverChangeStatusModel) : Observable<Response<ChangeStatusResponse>>
//
//    @GET("api/{cod_status}")
////    @GET("api/{cod_status}?status=process")
//    fun getCODParcel(@Header("Authorization") auth : String,@Path("cod_status") status: String,@Query("page") query : Int) : Observable<Response<CODParcelResponse>>
//
//    @GET("api/cod/{ID}")
//    fun getCODdetail(@Header("Authorization") auth: String, @Path("ID") ID : Int) : Observable<Response<CODParcel>>
//
//    @GET("api/label/{label}")
//    fun searchReceiveParcelList(@Header("Authorization") auth : String,@Path("label") label: String,  @Query("tracking_code") tracking_code: String) : Observable<Response<ParcelResponse>>
//
//    @GET("api/cod/search")
//    fun searchCODParcelList(@Header("Authorization") auth : String,@Query("status") status: String, @Query("tracking_code") tracking_code : String, @Query("type") type: String) : Observable<Response<CODParcelResponse>>
//
//    @GET("api/location/townships")
//    fun getTownship(@Header("Authorization") auth : String) : Observable<List<TownModel>>
//
//    @GET("api/label/configuration")
//    fun getTypesConfiguration(@Header("Authorization") auth : String) : Observable<Response<TypesConfigurationModel>>
//
//    @GET("api/branch")
//    fun getBranch(@Header("Authorization") auth : String,@Query("select") select : String) : Observable<Response<BranchModel>>
//
//    @GET("api/branch/all")
//    fun getBranchPostCode(@Header("Authorization") auth : String,@Query("select") select : String) : Observable<List<BranchPostCode>>
//
//    @GET("api/branch/township/{townshipid}")
//    fun getBranchTownship(@Header("Authorization") auth : String,@Path("townshipid") township : Int, @Query("select") select : String) : Observable<List<BranchPostCode>>
//
//    @POST("api/emo")
//    fun CreateEmo(@Header("Authorization") auth : String,@Body createEmoModel: CreateEmoModel) : Observable<Response<CreateEmoModel>>
//
//    @GET("api/emo/calculate_fee")
//    fun CalculateFee(@Header("Authorization") auth : String,@Query("amount") amount : Int, @Query("type") type: String) : Observable<Int>
//
//    @GET("api/emo/{type}")
//    fun EMOInboundOutbound(@Header("Authorization") auth : String,@Path("type") type : String, @Query("status") status : String ,@Query("page") page: Int) : Observable<Response<EMOResponse>>
//
//    @POST("api/emo/{emo}/{status}")
//    fun emoCancel(@Header("Authorization") auth : String,@Path("emo") id : Int,@Path("status") status: String) : Observable<Response<ReturnResponse>>
//
//    @GET("api/announcement/delivery")
//    fun InstructionList(@Header("Authorization") auth : String,@Query("page") page: Int) : Observable<Response<Instruction_Response>>
//
//    @GET("api/branch")
//    fun BranchPostOffice(@Header("Authorization") auth : String,@Query("page") page: Int) : Observable<Response<BranchModel>>
//
//    @POST("api/ticket/{label_id}")
//    fun CreateTicket(@Header("Authorization") auth : String, @Path("label_id") label_id : Int, @Body createTicketModel: CreateTicketModel) : Observable<Response<CreateTicketModel>>
//
//    @POST("api/ticket/emo/{id}")
//    fun CreateEMOTicket(@Header("Authorization") auth : String, @Path("id") emo_id : Int, @Body createTicketModel: CreateTicketModel) : Observable<Response<CreateTicketResponse>>
//
//
//    @GET("api/branch/search/advance")
//    fun searchPostOffice(@Header("Authorization") auth : String,@Query("q") status : String) : Observable<Response<BranchModel>>
//
//    @GET("api/label/searchByBranch")
//    fun missingLabel(@Header("Authorization") auth : String,@Query("status") status : String,@Query("page") page: Int) : Observable<Response<ParcelResponse>>
//
//    @GET("api/postbox/nearby")
//    fun getNearestPostBox(@Header("Authorization") auth : String,
//        @Query("lat") lat: Double, @Query("lng") lng: Double,@Query("max") max : String) : Observable<List<PostBoxResponse>>
//
//    @GET("api/mailbag-inbound/list/{status}?histories=true&labels=true")
//    fun getMailBagList(@Header("Authorization") auth : String,@Path("status") status: String,@Query("page") page: Int) : Observable<Response<MailBagInboundResponse>>
//
//    @GET("api/mailbag-outbound/list/{status}?histories=true&labels=true")
//    fun getOutboundMailbagList(@Header("Authorization") auth : String,@Path("status") status: String, @Query("page") page: Int) : Observable<Response<MailBagInboundResponse>>
//
//    @POST("api/mailbag-inbound/arrived-to-destination")
//    fun acceptMailbagInboundLabel(@Header("Authorization") auth : String,@Body postInboundModel: PostInboundModel) : Observable<Response<PostInboundResponse>>
//
//    @POST("api/mailbag-outbound/add-label")
//    fun addLabels(@Header("Authorization") auth : String,@Body addLabelsModel: AddLabelsModel) : Observable<Response<PostInboundResponse>>
//
//    @POST("api/mailbag-outbound/remove-label")
//    fun removeLabels(@Header("Authorization") auth : String,@Body removeLabelsModel: RemoveLabelsModel) : Observable<Response<PostInboundResponse>>
//
//    @GET("api/mailbag-outbound/detail/{id}?histories=true&labels=true")
//    fun OutboundDetail(@Header("Authorization") auth : String,@Path("id") id: Int) : Observable<Response<MailBagOutboundDetailResponse>>
//
//    @POST("api/mailbag-outbound/send-to-destination")
//    fun MailbagOutboundSend(@Header("Authorization") auth : String,@Query("bag_tracking_code") bag_tracking_code : String) : Observable<Response<PostInboundResponse>>
//
//    @Multipart
//    @POST("api/label/{id}/change_status")
//    fun SentbacktoCustomer(@Header("Authorization") auth : String,@Path("id") id : Int, @Part("action") status: RequestBody, @Part("meta") meta : RequestBody, @Part image: MultipartBody.Part) : Observable<Response<ReturnResponse>>
//
//    @POST("api/label/{id}/change_status")
//    fun SentbacktoOrigin(@Header("Authorization") auth : String,@Path("id") id : Int, @Body remarkDeliverChangeStatusModel: RemarkDeliverChangeStatusModel) : Observable<Response<ReturnResponse>>
//
//    @Multipart
//    @POST("api/label/{id}/change_status")
//    fun CompleteSendingLabel(@Header("Authorization") auth : String,@Path("id") id : String, @Part("action") status: RequestBody, @Part image: MultipartBody.Part) : Observable<Response<ReturnResponse>>
//
//    @POST("api/label/{id}/change_status")
//    fun rollbackLabel(@Header("Authorization") auth : String,@Path("id") id : String, @Query("action") status : String) : Observable<Response<ReturnResponse>>
//
//    @POST("api/emo/paid_delegate/{emo}")
//    @FormUrlEncoded
//    fun emopaiddelegate(@Header("Authorization") auth : String,@Path("emo") emo : Int,@Field("receiver") receiver : String) : Observable<Response<EMOResponse>>
//
//    @GET("api/emo/paid/{emo}")
//    fun emopaid(@Header("Authorization") auth : String,@Path("emo") emo: Int) : Observable<Response<EMOResponse>>
//
//    @FormUrlEncoded
//    @POST("api/forward/make-forward")
//    fun ForwardMail(@Header("Authorization") auth : String,@Field("label_tracking_code") label_tracking_code : String) : Observable<Response<ForwardMailResponse>>
//
//    @GET("api/forward/mailbag/search")
//    fun searchForwardMailbag(@Header("Authorization") auth : String,@Query("tracking_code") tracking_code: String) : Observable<Response<ForwardCheckInListDetailResponse>>
//
//    @FormUrlEncoded
//    @POST("api/forward/mailbag/checkin")
//    fun makeCheckIn(@Header("Authorization") auth : String,@Field("tracking_code") tracking_code : String) : Observable<Response<PostInboundResponse>>
//
//    @FormUrlEncoded
//    @POST("api/forward/mailbag/checkout")
//    fun makeCheckOut(@Header("Authorization") auth : String,@Field("tracking_code") tracking_code : String) : Observable<Response<PostInboundResponse>>
//
//    @GET("api/forward/mailbag/checkin/list")
//    fun getForwardCheckInList(@Header("Authorization") auth : String) : Observable<Response<ForwardCheckInListResponse>>
//
//    @GET("api/forward/mailbag/checkout/list")
//    fun getForwardCheckOutList(@Header("Authorization") auth : String) : Observable<Response<ForwardCheckInListResponse>>
//
//    @FormUrlEncoded
//    @POST("api/redirect/make-redirect")
//    fun RedirectMail(@Header("Authorization") auth : String,@Field("label_tracking_code") label_tracking_code : String,
//                     @Field("destination_postcode") destination_postcode : String, @Field("destination_no") destination_no : String,
//                     @Field("destination_street") destination_street : String,@Field("destination_quarter") destination_quarter : String) : Observable<Response<RedirectMailResponse>>
//
//    @POST("api/label/{ID}/accept/origin")
//    fun ApproveLabel(@Header("Authorization") auth : String,@Path("ID") ID : Int) : Observable<Response<ReturnResponse>>
//
//    @GET("api/emo/{id}")
//    fun EMOShow(@Header("Authorization") auth : String,@Path("id") id : Int) : Observable<Response<EMOData>>
//
//    @GET("api/search_branch/nearby")
//    fun PostOfficeNearBy(@Header("Authorization") auth : String,@Query("lat") lat : Double, @Query("lng") lng : Double, @Query("max") max : String) : Observable<List<PostOfficeNearBy>>
//
//    @POST("api/mailbag-outbound/create")
//    fun CreateOutboundMailbag(@Header("Authorization") auth : String,@Body createOutboundMailbagModel: CreateOutboundMailbagModel) : Observable<Response<MailBagCreateResponse>>
//
//    @GET("api/mailbag-inbound/serach_by_trackingcode/{tracking_code}?labels=true")
//    fun searchInboundMailbag(@Header("Authorization") auth : String,@Path("tracking_code") tracking_code : String) : Observable<Response<MailBagOutboundDetailResponse>>
//
//    //Daily Count
//
//    @GET("api/daily-account-report/show/{id}?reports=true&&logs=true")
//    fun DailyCount(@Header("Authorization") auth : String,@Path("id") id : Int) : Observable<Response<DailyReportDetail>>
//
//    @POST("api/daily-account-report/update/{id}")
//    fun summitDailyCount(@Header("Authorization") auth : String,@Path("id") id : Int, @Body dailyReportModel : DailyReportModel) : Observable<Response<DailyAccountSuccessResponse>>
//
//    @GET("api/daily-account-report/list?logs=true")
//    fun dailycountList(@Header("Authorization") auth : String,@Query("page") page : Int) : Observable<Response<DailyCountReportListResponse>>
//
//
//    @GET("api/mobile-apps/list")
//    fun AppList(@Header("Authorization") auth : String,@Query("version") version : Int) : Observable<Response<AppListResponse>>
//
//    @FormUrlEncoded
//    @POST("api/cod/paid/{ID}")
//    fun CODClearance(@Header("Authorization") auth : String,@Path("ID") ID : Int,@Field("cod_code") cod_code : String) : Observable<Response<ReturnResponse>>
//
//    @GET("api/sell-items/{type}")
//    fun getInventory(@Header("Authorization") auth: String ,@Path("type") type : String) : Observable<Response<StampResponse>>
//    //@Query("page") page: Int
//
//    //@POST("api/inventory-invoice")
//    //fun InventoryCheckOut(@Header("Authorization") auth: String,@Body sale: StockItemSell) : Observable<Response<ReturnResponse>>
//    @FormUrlEncoded
//    @POST("api/inventory-invoice")
//    fun InventoryCheckOut(@Header("Authorization") auth: String,@Field ("items") items : String, @Field("customer") customer : String,@Field("subtotal") subtotal : Int) : Observable<Response<InvoiceResponse>>
//
//    @FormUrlEncoded
//    @POST("api/delivery/phones")
//    fun postPhone(@Header("Authorization") auth: String, @Field("phones") phone: MutableList<String>) : Observable<Response<LoginUserResponse>>
//
//
//    @GET("api/inventory-invoice/list/{type}")
//    fun getInventorySellList(@Header("Authorization") auth: String, @Path("type") type : String) : Observable<Response<InventorySellResponse>>
//
//
////    @GET("<api-url>")
////    fun getPerson(): Deferred<NetworkResponse<LoginResponse, ErrorMessage>>
//
//    @POST("api/label/{label}/accept/origin")
//    fun acceptLabelpending(@Header("Authorization") auth: String, @Path("label") label : Int) : Observable<Response<ReturnResponse>>
//
//    @POST("api/label/{labelid}/boost_status")
//    fun deliveredEmergencyLabel(@Header("Authorization") auth: String, @Path("labelid") labelis : Int, @Body emergencyDeliverLabelModel: EmergencyDeliverLabelModel) : Observable<Response<ReturnResponse>>

}