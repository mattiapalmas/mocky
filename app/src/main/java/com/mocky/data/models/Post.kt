package com.mocky.data.models

data class Post(
    val id: Int,
    val user_id: Int,
    val title: String,
    val description: String,
    val image: String,
    val published_at: String
)