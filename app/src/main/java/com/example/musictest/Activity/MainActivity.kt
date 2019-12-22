package com.example.musictest.Activity


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musictest.R
import com.example.musictest.data.source.IDataSource
import com.example.musictest.data.source.Repository
import com.example.musictest.data.source.remote.model.ResultResponse
import com.example.musictest.viewmodel.MusicListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.HashMap
import android.view.View
import android.widget.SearchView

/**
 *
 */

class MainActivity : AppCompatActivity() {

    private lateinit var mListViewModel: MusicListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<com.example.musictest.databinding.ActivityMainBinding>(
            this@MainActivity,
            com.example.musictest.R.layout.activity_main
        )
        mListViewModel = ViewModelProviders.of(this).get(MusicListViewModel::class.java)
        binding.recyclerView.adapter = mListViewModel.musicListAdapter
        mListViewModel.getSearchData(getSearchRequest("jack+johnson"))
        mListViewModel.getSearchResult().observe(this, Observer {
            mListViewModel.loadMusic(it)
        })


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                if (binding.searchView.query.isNotEmpty()) {
                    mListViewModel.getSearchData(getSearchRequest(binding.searchView.query.toString()))
                }
                return false
            }
        })

    }

    /**
     *  to get search query request
     */
    private fun getSearchRequest(key: String): HashMap<String, String> {
        val request = java.util.HashMap<String, String>()
        request.put("term", key)

        return request
    }
}
