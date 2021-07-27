package com.mocky.data.api

import com.mocky.data.models.PostsJson
import retrofit2.http.GET

interface PostsApi {

    @GET("v2/59f2e79c2f0000ae29542931")
    suspend fun getPosts(): PostsJson
}