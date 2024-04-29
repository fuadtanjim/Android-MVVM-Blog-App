package com.example.mvvmblogapp.feature.blog_list.model

interface BlogModel {
    fun fetchBlogList(callback: ModelCallBack)
}