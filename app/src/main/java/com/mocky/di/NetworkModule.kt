package com.mocky.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mocky.common.Constants.API_URL
import com.mocky.data.api.PostsApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { providePostsApi() }
}

fun provideGson(): Gson = GsonBuilder()
    .setLenient()
    .create()

fun provideConverterFactory(
    gson: Gson = provideGson()
): Converter.Factory = GsonConverterFactory.create(gson)

fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder().build()

fun providePostsApi(
    domain: String = API_URL,
    okHttpClient: OkHttpClient = provideOkHttp(),
    converterFactory: Converter.Factory = provideConverterFactory()
): PostsApi = Retrofit.Builder()
    .baseUrl(domain)
    .client(okHttpClient)
    .addConverterFactory(converterFactory)
    .build()
    .create(PostsApi::class.java)