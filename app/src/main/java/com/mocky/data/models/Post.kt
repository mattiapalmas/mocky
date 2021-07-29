package com.mocky.data.models

import com.mocky.common.Constants.UI_DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.*

data class Post(
    val id: Int,
    val user_id: Int,
    val title: String,
    val description: String,
    val image: String,
    val published_at: String
) {
    fun toPostRoom() = PostRoom(id, user_id, title, description, image, published_at)

    fun getPublishedAtCalendar(): Calendar {
        val calendarPublishedAt = Calendar.getInstance()
        val formatter = SimpleDateFormat(UI_DATE_FORMAT, Locale.getDefault())
        calendarPublishedAt.time = formatter.parse(published_at)!!

        return calendarPublishedAt
    }
}
