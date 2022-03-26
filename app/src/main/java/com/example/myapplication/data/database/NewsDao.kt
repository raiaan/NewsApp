package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.models.Articles
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert
    suspend fun insertUser(register: User)


    @Query("SELECT * FROM users WHERE email LIKE :email")
    suspend fun getUserEmail(email: String): User?
    @Query("SELECT * FROM articles ORDER BY publishedAt ASC")
    fun getCachedArticles(): Flow<List<Articles>>
    @Insert
    fun addArticle(article:Articles)

}