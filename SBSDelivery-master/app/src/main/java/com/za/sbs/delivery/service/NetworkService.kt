package com.za.sbs.delivery.service

import android.content.Context
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import com.za.sbs.delivery.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService private constructor(context: Context) {
    var apiService: ApiService
    var retrofit: Retrofit
    var version = BuildConfig.VERSION_NAME

    init {
        val interceptor = Interceptor { chain ->
            val request = chain?.request()?.newBuilder()
                ?.addHeader("X-APP-VERSION", "v-$version")
                ?.addHeader("X-APP", "MyanmarPost Manager")
                ?.addHeader("X-API-TOKEN", "71b00e58e83808f05692f5b709c4c23d") //71b00e58e83808f05692f5b709c4c23d //1ce960cc22de5b8e7782097f36225d24
                ?.addHeader("Content-Type", "application/json")
                ?.addHeader("Accept", "application/json")
                ?.build()
            chain?.proceed(request)
        }
        val http: HttpLoggingInterceptor = HttpLoggingInterceptor()
        http.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(ChuckInterceptor(context))
            .addInterceptor(http)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .baseUrl("https://myanmarpost.zacompany.dev/")
            //https://myanmarpost.zacompany.dev/
            // https://trackingmonitoring.systems/
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    companion object : SingletonHolder<NetworkService, Context>(::NetworkService)
}