package com.mocky.screens.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mocky.R
import com.mocky.common.adapters.PostsAdapter
import com.mocky.data.models.Post
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private var postsList: ArrayList<Post> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeLiveData()
        setupPostsRecyclerView()
        handleMainToggleBtn()
        viewModel.loadPosts()
    }

    private fun observeLiveData() {
        viewModel.postsLiveData.observe(this, {
            postsList.clear()
            postsList.addAll(it)
            posts_rv.adapter?.notifyDataSetChanged()
        })

        viewModel.showErrorLiveData.observe(this, {
            showSnackbar(it.errorMessage)
        })

        viewModel.showProgressLiveData.observe(this, {
            showProgressBar(it)
        })
    }

    private fun setupPostsRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        posts_rv.layoutManager = layoutManager
        posts_rv.adapter =
            PostsAdapter(postsList)
    }

    private fun handleMainToggleBtn() {
        main_toggle_btn.setOnCheckedChangeListener { _, isChecked ->
            viewModel.postsLiveData.value?.let { posts ->
                postsList.clear()

                if (isChecked) {
                    val filteredPosts = posts.filter { it.user_id == 1 }
                    val postsOrdered =
                        filteredPosts.sortedByDescending { it.getPublishedAtCalendar() }

                    postsList.addAll(postsOrdered)
                } else {
                    postsList.addAll(posts)
                }

                posts_rv.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun showSnackbar(error: String) {
        Snackbar.make(main_layout, error, Snackbar.LENGTH_LONG)
            .setDuration(Snackbar.LENGTH_LONG)
            .show()
    }

    private fun showProgressBar(isShown: Boolean) {
        progress_bar.isVisible = isShown
    }
}