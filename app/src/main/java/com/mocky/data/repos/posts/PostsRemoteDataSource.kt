package com.mocky.data.repos.posts

import com.mocky.data.api.PostsApi
import com.mocky.data.models.Post

class PostsRemoteDataSource(
    private val postsApi: PostsApi
) : PostsDataSource {

    override suspend fun getPosts(): List<Post> {
        return postsApi.getPosts().posts
    }
}