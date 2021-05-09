package com.example.newsapp.news

import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.newsapp.BaseActivity
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsActivityBinding
import com.example.newsapp.network.Status
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
                            if (articles.isNotEmpty()) {
                            }
                        }
                    }

                    Status.Error -> {
                        Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show()
                    }

                    Status.Loading -> {

                    }
                }
            }
        }
    }

}