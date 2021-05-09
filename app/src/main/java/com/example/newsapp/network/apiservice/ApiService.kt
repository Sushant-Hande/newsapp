package com.example.newsapp.network.apiservice

import com.example.newsapp.network.ApiResponse
import com.example.newsapp.news.NewsViewModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by shande on 09-05-2021
 */
interface ApiService {

    @GET("top-headlines")
    suspend fun getHeadLines(
        @Query(COUNTRY) country: String,
        @Query(API_KEY) apKey: String
    ): ApiResponse


    companion object {
        const val API_KEY = "apiKey"
        const val COUNTRY = "country"
        const val PAGE = "page"
    }
}
