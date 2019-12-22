package com.example.musictest.data.source.remote.model


import com.google.gson.annotations.SerializedName


data class ResultResponse(

	@field:SerializedName("resultCount")
	val resultCount: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem>? = null
)