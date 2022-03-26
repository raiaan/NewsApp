package com.example.myapplication.data.models
import com.google.gson.annotations.SerializedName

data class Json4Kotlin_Base (

	val status : String,
	val totalResults : Int,
	val articles : List<Articles>
)