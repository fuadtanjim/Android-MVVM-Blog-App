package com.example.mvvmblogapp.feature.blog_list.model

interface ModelCallBack {
    fun onSuccess(list: List<BlogResponse>)
    fun onError(error: String)
}