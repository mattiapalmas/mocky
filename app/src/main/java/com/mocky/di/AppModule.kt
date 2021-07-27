package com.mocky.di

import com.mocky.data.repos.posts.PostsRepo
import com.mocky.screens.mainactivity.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get() as PostsRepo) }
}