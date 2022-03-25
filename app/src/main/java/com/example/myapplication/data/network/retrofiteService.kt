package com.example.myapplication.data.network

import com.example.myapplication.data.models.Json4Kotlin_Base
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface retrofiteService {
    @GET("onecall")
    suspend fun allNews(@Query("lat", encoded=true) lat:String,
                               @Query("lon", encoded=true) lon:String,
                               @Query("units") Units : String = "metric",
                               @Query("lang") language : String = "en",
                               @Query("exclud", encoded=true) exclude:String ="daily",
                               @Query("appid", encoded=true) appid:String = apiKey): Response<Json4Kotlin_Base>

    companion object {
        var retrofitService: retrofiteService? = null
        fun getInstance(): retrofiteService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(retrofiteService::class.java)
            }
            return retrofitService!!
        }
    }
}