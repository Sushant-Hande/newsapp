package com.example.newsapp.newsdetails

import androidx.databinding.DataBindingUtil
import coil.load
import com.example.newsapp.BaseActivity
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsDetailsActivityBinding
import com.example.newsapp.model.NewsModel

class NewsDetailsActivity : BaseActivity() {
    lateinit var binding: NewsDetailsActivityBinding


    override fun initializeViewBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.news_details_activity)
        intent.getParcelableExtra<NewsModel>(NEWS)?.let { news ->
            with(binding) {
                ivNews.load(news.urlToImage)
                tvTitle.text = news.title
                tvDescription.text = news.description
                toolbarLayout.title = news.source?.name
            }
        }
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    override fun observeViewModel() {

    }

    companion object {
        const val NEWS = "news"
    }
}