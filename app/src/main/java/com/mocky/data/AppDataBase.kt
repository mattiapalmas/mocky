package com.mocky.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mocky.data.models.PostRoom
import com.mocky.data.repos.posts.PostsDao

@Database(entities = [PostRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}