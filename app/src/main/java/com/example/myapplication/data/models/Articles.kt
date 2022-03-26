package com.example.myapplication.data.models

import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity(tableName = "articles",indices = [Index(value = ["url"],unique = true)])
data class Articles (
	@SerializedName("author") val author : String?,
	@SerializedName("title") val title : String?,
	@SerializedName("description") val description : String?,
	@SerializedName("url") val url : String?,
	@SerializedName("urlToImage") val urlToImage : String?,
	@SerializedName("publishedAt") val publishedAt : String?,
	@SerializedName("content") val content : String?

):Serializable {
	@ColumnInfo(name="isFavourite")
	var isFavourite: Boolean = false
	@Ignore @SerializedName("source") val source : Source? = null
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name="id")
	  var id :Int= 0
}

