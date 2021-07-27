package com.mocky.screens.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mocky.common.errors.GeneralError
import com.mocky.data.models.Post
import com.mocky.data.repos.posts.PostsDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val postsRepo: PostsDataSource
) : ViewModel() {

    val postsLiveData: LiveData<List<Post>> get() = postsMutableLiveData
    private val postsMutableLiveData = MutableLiveData<List<Post>>()

    val showErrorLiveData: LiveData<GeneralError> get() = showErrorMutableLiveData
    private val showErrorMutableLiveData = MutableLiveData<GeneralError>()

    fun loadPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                postsRepo.getPosts()
            }
                .onSuccess { result -> postsMutableLiveData.postValue(result) }
                .onFailure { error ->
                    showErrorMutableLiveData.postValue(
                        GeneralError(
                            "Something went wrong fetching posts",
                            error
                        )
                    )
                }
        }
    }
}