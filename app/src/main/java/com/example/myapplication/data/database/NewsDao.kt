package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.models.Articles
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM articles ORDER BY publishedAt ASC")
    fun getCachedArticles(): List<Articles>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun addArticle(article:Articles)

}