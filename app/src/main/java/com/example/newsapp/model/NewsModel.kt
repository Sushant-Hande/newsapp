package com.example.newsapp.model

/**
 * Created by shande on 09-05-2021
 */
data class NewsModel(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
    val source: Source
)