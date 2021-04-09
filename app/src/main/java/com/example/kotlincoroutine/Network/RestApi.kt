package com.example.kotlincoroutine.Network

import com.example.kotlincoroutine.Model.Post
import retrofit2.http.GET

interface RestApi {
    @GET("posts")
    suspend fun getPostList():List<Post>
}