package com.example.mvvmblogapp.feature.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://hellohasan.com/wp-json/wp/v2/"

    private var retrofit: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    val client: Retrofit get() {
        if(retrofit == null) {
            synchronized(Retrofit::class.java) {
                if(retrofit == null) {
                    val httpClient = OkHttpClient.Builder().build()
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(httpClient)
                        .build()
                }
            }
        }
        return retrofit!!
    }
}