package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.models.Articles
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM articles ORDER BY publishedAt ASC")
    fun getCachedArticles(): Flow<List<Articles>>
    @Insert
    fun addArticle(article:Articles)

}