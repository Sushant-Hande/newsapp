package com.example.newsapp.news

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.newsapp.BaseActivity
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.NewsActivityBinding
import com.example.newsapp.model.NewsModel
import com.example.newsapp.network.Status
import com.example.newsapp.newsdetails.NewsDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : BaseActivity() {
    lateinit var binding: NewsActivityBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun initializeViewBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.news_activity)
    }

    override fun observeViewModel() {
        viewModel.getHeadlines().observe(this) {
            it.let { resource ->
                when (resource.status) {

                    Status.Success -> {
                        resource.data?.articles?.let { articles ->
                            binding.progressBar.isVisible = false
                            if (articles.isNotEmpty()) {
                                setNewsList(articles)
                            }
                        }
                    }

                    Status.Error -> {
                        Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show()
                    }

                    Status.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.progressBar.animate()
                        binding.progressBar.bringToFront()
                    }
                }
            }
        }
    }

    private fun setNewsList(newsList: List<NewsModel>) {
        binding.rvNews.setHasFixedSize(true)
        binding.rvNews.adapter = NewsAdapter(newsList) { news ->
            Intent(this, NewsDetailsActivity::class.java).apply {
                putExtra(NewsDetailsActivity.NEWS, news)
                startActivity(this)
            }
        }
    }

}