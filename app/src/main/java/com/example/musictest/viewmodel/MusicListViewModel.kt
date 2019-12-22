package com.example.musictest.viewmodel

import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musictest.Adapter.MusicListAdapter
import com.example.musictest.data.source.IDataSource
import com.example.musictest.data.source.Repository
import com.example.musictest.data.source.remote.model.ResultResponse
import com.example.musictest.data.source.remote.model.ResultsItem
import java.util.HashMap

class MusicListViewModel :ViewModel(){

    lateinit var allMusicList : ArrayList<ResultsItem>
     var musicListAdapter = MusicListAdapter()
    private val mSearchResult = MutableLiveData<ResultResponse>()

    fun loadMusic(data: ResultResponse?) {
        allMusicList = ArrayList()
        allMusicList.addAll(data?.results!!)
        musicListAdapter.updateMusicList(allMusicList)
    }

    fun getSearchData(requestBody: HashMap<String, String>){
        Repository.getSearchResult(requestBody, object : IDataSource
        .LoadDataCallback<ResultResponse> {
            override fun onDataLoaded(data: ResultResponse) {
                mSearchResult.value  = data
                Log.d("response",data.toString())
            }

            override fun onDataNotAvailable(t: Throwable) {
                Log.d("response","fails")

            }
        })
    }


    fun getSearchResult()= mSearchResult;


}