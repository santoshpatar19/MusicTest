package com.example.musictest.data.source.remote

import com.example.musictest.data.source.remote.model.ResultResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url


interface ApiService {
    @GET("https://itunes.apple.com/search")
    fun getSearchResult(@QueryMap request: HashMap<String, String>): Call<ResultResponse>


}

