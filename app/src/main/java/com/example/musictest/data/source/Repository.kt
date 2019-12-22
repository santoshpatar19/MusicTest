package com.example.musictest.data.source


import com.example.musictest.data.source.remote.RemoteDataSource
import com.example.musictest.data.source.remote.model.ResultResponse
import com.primefocus.mobile.contentlive.data.source.local.LocalDataSource

import okhttp3.ResponseBody

object Repository : IRepository {

    private var remoteDataSource: RemoteDataSource? = null

    private var localDataSource: LocalDataSource? = null

    init {
        remoteDataSource = RemoteDataSource
    }

    override fun getSearchResult(
        request: HashMap<String, String>,
        callback: IDataSource.LoadDataCallback<ResultResponse>) {
        remoteDataSource?.getSearchResult(request,
            object : IDataSource.LoadDataCallback<ResultResponse> {

                override fun onDataLoaded(data: ResultResponse) {
                    callback.onDataLoaded(data)
                }

                override fun onDataNotAvailable(t: Throwable) {
                    callback.onDataNotAvailable(t)
                }
            })
    }
}