package com.mocky.screens.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.mocky.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeLiveData()
        viewModel.loadPosts()
    }

    private fun observeLiveData() {
        viewModel.postsLiveData.observe(this, {
            it.size
        })
        
        viewModel.showErrorLiveData.observe(this, {
            showSnackbar(it.errorMessage)
        })
    }

    private fun showSnackbar(error: String) {
        Snackbar.make(main_layout, error, Snackbar.LENGTH_LONG).show()
    }
}