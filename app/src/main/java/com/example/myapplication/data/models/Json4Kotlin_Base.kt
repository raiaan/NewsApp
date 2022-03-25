package com.example.myapplication.data.models
import com.google.gson.annotations.SerializedName

data class Json4Kotlin_Base (

	@SerializedName("status") val status : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("articles") val articles : List<Articles>
)