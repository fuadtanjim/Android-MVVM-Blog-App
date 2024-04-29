package com.example.mvvmblogapp.feature.blog_list.model

import com.example.mvvmblogapp.feature.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class BlogModelImpl : BlogModel {

    private val blogApiInterface = RetrofitClient.client.create<BlogApiInterface>()

    override fun fetchBlogList(callback: ModelCallBack) {

        val apiCall = blogApiInterface.getBlogList()

        apiCall.enqueue(object : Callback<List<BlogResponse>> {
            override fun onResponse(
                call: Call<List<BlogResponse>>,
                response: Response<List<BlogResponse>>
            ) {
                val blogList = response.body()
                if(blogList.isNullOrEmpty()) {
                    callback.onError("Content not found")
                } else {
                    callback.onSuccess(blogList)
                }
            }

            override fun onFailure(call: Call<List<BlogResponse>>, t: Throwable) {
                callback.onError(t.message?: "Something went wrong")
            }
        })
    }
}