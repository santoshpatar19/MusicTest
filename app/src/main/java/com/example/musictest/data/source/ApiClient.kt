package com.example.musictest.data.source

import android.widget.Toast
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import android.os.Looper
import com.example.musictest.BuildConfig
import com.example.musictest.R
import com.example.musictest.data.source.remote.ApiService
import com.example.musictest.utils.AppConstant

import java.util.concurrent.TimeUnit

object ApiClient {
    fun getRetrofitService(): ApiService {

        val client = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS).build()

        return Retrofit.Builder()
                .baseUrl(AppConstant.HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build().create(ApiService::class.java)
    }
}