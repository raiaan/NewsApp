package com.example.myapplication.data.network

import com.example.myapplication.data.models.Json4Kotlin_Base
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofiteService {
    @GET("top-headlines")
    suspend fun allNews(@Query("sortBy", encoded=true) order:String ="publishedAt",
                        @Query("from") from:String ="2022-02-25",
                        @Query("country") country:String = "EG",
                               @Query("apiKey", encoded=true) appid:String = apiKey): Response<Json4Kotlin_Base>
    companion object {
        var retrofitOBJ: RetrofiteService? = null
        fun getInstance(): RetrofiteService {
            if (retrofitOBJ == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitOBJ = retrofit.create(RetrofiteService::class.java)
            }
            return retrofitOBJ!!
        }
    }
}