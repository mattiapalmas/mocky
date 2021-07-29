package com.mocky.data.repos.posts

import com.mocky.data.models.Post

interface PostsLocalDataSource {
    suspend fun getPosts(): List<Post>
    suspend fun savePosts(posts: List<Post>)
}