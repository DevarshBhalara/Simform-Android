package com.example.demoproject.recyclerview.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ItemUserReviewBinding

class SeriesUserReview: RecyclerView.Adapter<SeriesUserReview.ViewHolder>() {
    private val reviews: MutableList<String> = mutableListOf()
    inner class ViewHolder(private val binding: ItemUserReviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(review: String) {
            binding.review = review
            Log.e("review", binding.review.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return reviews.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitReview(list: List<String>) {
        reviews.clear()
        reviews.addAll(list)
        notifyDataSetChanged()
    }
}