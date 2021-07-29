package com.mocky.data.repos.posts

import com.mocky.data.models.Post

class PostsRoomDataSource(
    private val postsDao: PostsDao
) : PostsLocalDataSource {

    override suspend fun getPosts(): List<Post> {
        return postsDao.get().map { it.toPost() }
    }

    override suspend fun savePosts(posts: List<Post>) {
        postsDao.save(posts.map { it.toPostRoom() })
    }
}