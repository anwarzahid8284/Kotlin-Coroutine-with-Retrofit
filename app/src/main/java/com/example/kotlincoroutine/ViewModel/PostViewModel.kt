package com.example.kotlincoroutine.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutine.Model.Post
import com.example.kotlincoroutine.Repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) :ViewModel(){
    val postLiveData:MutableLiveData<List<Post>> = MutableLiveData()

    fun liveData(){
        viewModelScope.launch {
           val response=postRepository.getAllPost()
            postLiveData.value=response
        }
    }
}