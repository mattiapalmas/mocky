package com.mocky.data.repos.posts

import com.mocky.data.models.Post

class PostsLocalDataSource(): PostsDataSource {

    override suspend fun getPosts(): List<Post> {
        return listOf()
    }
}