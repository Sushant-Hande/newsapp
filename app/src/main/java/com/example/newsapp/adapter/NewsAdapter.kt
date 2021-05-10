package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.model.NewsModel

/**
 * Created by shande on 10-05-2021
 */
class NewsAdapter(
    private var newsList: List<NewsModel>,
    private val onNewsSelected: (news: NewsModel) -> Unit
) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: NewsItemBinding =
            NewsItemBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position], onNewsSelected)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class NewsViewHolder(private val itemBinding: NewsItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(news: NewsModel, onNewsSelected: (news: NewsModel) -> Unit) {
            with(itemBinding) {
                ivNews.load(news.urlToImage) {
                    placeholder(R.drawable.ic_placeholder)
                    diskCachePolicy(CachePolicy.ENABLED)
                }
                tvTitle.text = news.title
                tvDescription.text = news.description
                tvDate.text = news.publishedAt
                tvSource.text = news.source?.name
                viewOverlay.setOnClickListener {
                    onNewsSelected(news)
                }
                executePendingBindings()
            }
        }
    }
}