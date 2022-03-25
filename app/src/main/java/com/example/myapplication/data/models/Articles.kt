package com.example.myapplication.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "articles",indices = [Index(value = ["url"],unique = true)])
data class Articles (
	@SerializedName("source") val source : Source,
	@SerializedName("author") val author : String,
	@SerializedName("title") val title : String,
	@SerializedName("description") val description : String,
	@SerializedName("url") val url : String,
	@SerializedName("urlToImage") val urlToImage : String,
	@SerializedName("publishedAt") val publishedAt : String,
	@SerializedName("content") val content : String

) {
	@ColumnInfo(name="isFavourite")
	val isFavourite: Boolean = false
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name="id")
	  val id :Int= 0
}

