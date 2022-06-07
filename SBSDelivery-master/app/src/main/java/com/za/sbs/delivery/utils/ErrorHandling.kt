package com.za.sbs.delivery.utils

import android.content.Context

class ErrorHandling(private val context: Context)  {

//    fun errorHandler(error: Throwable): Throwable {
//        if (error is HttpException) {
////            Timber.d("ErrorHandler CODE ::  ${error.code()} RESPONSE  :: ${error.response()} MESSAGE :: ${error.message()}")
//            if (error.code() == ErrorStatus.UNAUTHORIZED.value) {
//
//                val res = error.response()?.errorBody()?.string()
//                if(res!=null){
//                    val message  = JSONObject(res)
//                    if(message.has("message")){
//                        return Throwable(message = message.getString("message").toConverted())
//                    }
//                }
//                return Throwable(context.getString(R.string.lb_unauthrorizad_error).toConverted())
//            }
//        } else if (error is UnknownHostException) {
//            return Throwable(context.getString(R.string.lb_network_error).toConverted())
//        }
//        return Throwable(context.getString(R.string.lb_unknown_error).toConverted())
//    }
}