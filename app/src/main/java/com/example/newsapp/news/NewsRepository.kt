package com.example.newsapp.news

import com.example.newsapp.network.apihelper.ApiHelper
import javax.inject.Inject

/**
 * Created by shande on 09-05-2021
 */
class NewsRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getHeadlines() = apiHelper.getHeadlines()

}