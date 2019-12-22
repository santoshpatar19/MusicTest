package com.example.musictest.data.source.remote



import com.example.musictest.data.source.IDataSource
import com.example.musictest.data.source.remote.model.ResultResponse

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Url

interface IRemoteDataSource : IDataSource {

    fun getSearchResult( request: HashMap<String, String>, callback: IDataSource.LoadDataCallback<ResultResponse>)


}

