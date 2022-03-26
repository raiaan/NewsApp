package com.example.myapplication.data.models

import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity(tableName = "articles",indices = [Index(value = ["url"],unique = true)])
data class Articles (
	val author : String?,
	val title : String?,
	val description : String?,
	@PrimaryKey  val url : String,
	val urlToImage : String?,
	val publishedAt : String?,
	val content : String?

):Serializable {
	@ColumnInfo(name="isFavourite")
	var isFavourite: Boolean = false
	@Ignore val source : Source? = null
}

