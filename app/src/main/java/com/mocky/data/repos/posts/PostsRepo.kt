package com.mocky.data.repos.posts

import com.mocky.data.models.Post

class PostsRepo(
    private val localDataSource: PostsDataSource,
    private val remoteDataSource: PostsDataSource
): PostsDataSource {

    override suspend fun getPosts(): List<Post> {
        return remoteDataSource.getPosts()
    }
}