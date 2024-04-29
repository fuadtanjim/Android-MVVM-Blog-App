package com.example.mvvmblogapp.feature.blog_list.model

import retrofit2.Call
import retrofit2.http.GET

interface BlogApiInterface {

    @GET("posts")
    fun getBlogList(): Call<List<BlogResponse>>
}