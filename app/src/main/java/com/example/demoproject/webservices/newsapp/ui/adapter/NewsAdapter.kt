package com.example.demoproject.webservices.newsapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoproject.R
import com.example.demoproject.databinding.ItemNewsBinding
import com.example.demoproject.webservices.newsapp.ui.ActivityNewsArtical
import com.example.demoproject.webservices.newsapp.ui.model.Articles

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    val news: MutableList<Articles> = mutableListOf()

    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: Articles) {
            binding.news = news

                Glide.with(binding.root.context)
                    .load(news.urlToImage)
                    .into(binding.imgNews)

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, ActivityNewsArtical::class.java)
                intent.putExtra("url", news.url)
                binding.root.context.startActivity(intent)
            }


            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return news.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNews(list: List<Articles>) {
        news.clear()
        news.addAll(list)
        notifyDataSetChanged()
    }
}