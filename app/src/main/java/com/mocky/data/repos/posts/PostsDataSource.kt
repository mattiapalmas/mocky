package com.mocky.data.repos.posts

import com.mocky.data.models.Post

interface PostsDataSource {
    suspend fun getPosts(): List<Post>
}