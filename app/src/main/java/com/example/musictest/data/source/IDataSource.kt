package com.example.musictest.data.source

interface IDataSource {

    interface LoadDataCallback<T> {
        fun onDataLoaded(data: T)

        fun onDataNotAvailable(t: Throwable)
    }
}