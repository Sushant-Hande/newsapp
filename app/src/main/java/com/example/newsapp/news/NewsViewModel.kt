package com.example.newsapp.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.newsapp.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by shande on 09-05-2021
 */
@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    fun getHeadlines() = liveData {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = newsRepository.getHeadlines()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }

}