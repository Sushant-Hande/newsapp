package com.example.newsapp.network.apihelper


import com.example.newsapp.API_KEY
import com.example.newsapp.COUNTRY
import com.example.newsapp.network.apiservice.ApiService
import javax.inject.Inject

/**
 * Created by shande on 09-05-2021
 */
class ApiHelper @Inject constructor(private val apiService: ApiService) {

    suspend fun getHeadlines() = apiService.getHeadLines(COUNTRY, API_KEY)

}