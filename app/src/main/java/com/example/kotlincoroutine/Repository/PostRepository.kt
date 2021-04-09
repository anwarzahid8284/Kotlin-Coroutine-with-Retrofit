package com.example.kotlincoroutine.Repository

import com.example.kotlincoroutine.Model.Post
import com.example.kotlincoroutine.Network.RetrofitBuilder

class PostRepository {
    suspend fun getAllPost():List<Post> =RetrofitBuilder.restApi.getPostList()
}