package com.mocky.di

import com.mocky.data.AppDatabase
import com.mocky.data.api.PostsApi
import com.mocky.data.repos.posts.PostsLocalDataSource
import com.mocky.data.repos.posts.PostsRemoteDataSource
import com.mocky.data.repos.posts.PostsRepo
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        AppDatabase.getInstance(androidApplication())
    }

    single { PostsRemoteDataSource(get()) }
    single { PostsLocalDataSource() }
    single { PostsRepo(get() as PostsLocalDataSource, get() as PostsRemoteDataSource) }

}