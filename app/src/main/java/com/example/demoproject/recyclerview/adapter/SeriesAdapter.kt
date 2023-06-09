package com.example.demoproject.recyclerview.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ItemExpanableRecyclerviewBinding
import com.example.demoproject.recyclerview.model.Series

class SeriesAdapter : RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {
    val series: MutableList<Series> = mutableListOf()

    inner class ViewHolder(private val binding: ItemExpanableRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val reviewAdapter = SeriesUserReview()

        fun bind(series: Series) {
            binding.details.rvReview.adapter = reviewAdapter
            reviewAdapter.submitReview(series.review)
            binding.details.root.visibility = View.GONE
            binding.series = series
        }

        @SuppressLint("NotifyDataSetChanged")
        fun expandOrCollapse(position: Int) {
            binding.root.setOnClickListener {
                series[position].isExpanded = !series[position].isExpanded
                notifyItemChanged(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExpanableRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return series.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("Items :" , series.count().toString())
        holder.bind(series[position])
        holder.expandOrCollapse(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Series>) {
        series.clear()
        series.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(list: Series) {
        series.add(list)
        notifyItemChanged(series.count())
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: MutableList<Series>) {
        series.clear()
        series.addAll(filteredList)
        notifyDataSetChanged()
    }
}