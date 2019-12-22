package com.example.musictest.data.source

import com.example.musictest.data.source.IDataSource
import com.example.musictest.data.source.remote.model.ResultResponse
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.Url

interface IRepository {

    fun getSearchResult( request: HashMap<String, String>,
                         callback: IDataSource.LoadDataCallback<ResultResponse>)

}