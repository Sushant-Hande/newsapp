package com.example.newsapp.network

import com.example.newsapp.model.NewsModel
import com.squareup.moshi.Json

/**
 * Created by shande on 09-05-2021
 */
class ApiResponse {

    @field:Json(name = "status")
    val status: String = ""

    @field:Json(name = "totalResults")
    val totalResults: Int = 0

    @field:Json(name = "articles")
    val articles: List<NewsModel>? = null

}