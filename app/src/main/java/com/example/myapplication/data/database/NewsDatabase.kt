package com.example.myapplication.data.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.models.Articles
import com.example.myapplication.data.models.User

@Database(entities = [Articles::class,User::class], version =2)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
        companion object {
            @Volatile
            private var INSTANCE: NewsDatabase? = null

            fun getInstance(context: Context): NewsDatabase {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context,
                        NewsDatabase::class.java,
                        "word_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                    instance
                }
            }
        }
    }
