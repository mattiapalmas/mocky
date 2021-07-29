package com.mocky.di

import androidx.room.Room
import com.mocky.common.Constants.DATABASE_NAME
import com.mocky.data.AppDatabase
import com.mocky.data.repos.posts.PostsRemoteDataSource
import com.mocky.data.repos.posts.PostsRepo
import com.mocky.data.repos.posts.PostsRoomDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().postsDao() }

    single { PostsRemoteDataSource(get()) }
    single { PostsRoomDataSource(get()) }
    single { PostsRepo(get() as PostsRoomDataSource, get() as PostsRemoteDataSource, get()) }

}