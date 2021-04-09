package com.example.kotlincoroutine.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val restApi: RestApi by lazy {
        retrofit.create(RestApi::class.java)
    }
}