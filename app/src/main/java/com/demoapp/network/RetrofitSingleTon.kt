package com.demoapp.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class RetrofitSingleTon private constructor() {

    object HOLDER {
        val instance = RetrofitSingleTon()
    }

    companion object {
        @JvmStatic
        fun getInstance() = HOLDER.instance
    }


    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com/")
            .addCallAdapterFactory(getRxJava2CallAdapterFactory())
            .addConverterFactory(getGsonConverterFactory())
            .client(getOkHttpBuilder().build())
            .build()
    }

    fun getRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create();
    }

    fun getGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(getGson())
    }

    fun getGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    fun getOkHttpBuilder(): OkHttpClient.Builder {
        val httpClient: OkHttpClient.Builder = OkHttpClient().newBuilder()

        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        httpClient.readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(80, TimeUnit.SECONDS)


        return httpClient
    }

    fun getAPIService(): APIService {
        return getRetrofit().create(APIService::class.java)
    }


}