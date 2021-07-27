package com.mocky.common.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mocky.R
import com.mocky.common.viewholders.PostsViewHolder
import com.mocky.data.models.Post

class PostsAdapter(
    private var posts: ArrayList<Post>
) : RecyclerView.Adapter<PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item, parent, false)

        return PostsViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(posts[position])
    }
}