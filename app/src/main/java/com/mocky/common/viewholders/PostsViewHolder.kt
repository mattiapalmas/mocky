package com.mocky.common.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mocky.data.models.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.post_item.view.*

class PostsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(
        post: Post
    ) = with(itemView) {
        loadImage(post.image)
        published_at_tv.text = post.published_at
        title_tv.text = post.title
        description_tv.text = post.description
    }

    private fun loadImage(image: String) = with(itemView) {
        Picasso.get()
            .load(image)
            .fit()
            .centerCrop()
            .into(main_iv)
    }
}