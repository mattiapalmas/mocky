package com.mocky.data.repos.posts

import android.content.Context
import com.mocky.common.extensions.isNetworkAvailable
import com.mocky.data.models.Post


class PostsRepo(
    private val localDataSource: PostsLocalDataSource,
    private val remoteDataSource: PostsDataSource,
    private val androidContext: Context
) : PostsDataSource {

    override suspend fun getPosts(): List<Post> {
        return when {
            androidContext.isNetworkAvailable() -> {
                val posts = remoteDataSource.getPosts()
                localDataSource.savePosts(posts)
                posts
            }
            localDataSource.getPosts().isNotEmpty() -> {
                localDataSource.getPosts()
            }
            else -> {
                throw Throwable("Couldn't fetch posts, check your internet connection.")
            }
        }
    }
}