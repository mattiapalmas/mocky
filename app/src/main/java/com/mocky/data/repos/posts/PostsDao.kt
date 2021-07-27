package com.mocky.data.repos.posts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mocky.data.models.PostRoom

@Dao
interface PostsDao {

    /*@Query("SELECT * FROM posts")
    suspend fun get(): List<PostRoom>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun save(posts: List<PostRoom>)*/
}