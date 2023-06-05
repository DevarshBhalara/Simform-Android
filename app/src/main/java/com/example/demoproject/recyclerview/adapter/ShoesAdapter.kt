package com.example.demoproject.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ItemShoesGridBinding
import com.example.demoproject.recyclerview.model.Shoes
import com.example.demoproject.recyclerview.pagination.PaginationScrollListner

class ShoesAdapter: RecyclerView.Adapter<ShoesAdapter.ViewHolder>() {
    private val shoes: MutableList<Shoes> = mutableListOf()

    class ViewHolder(private val binding: ItemShoesGridBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Shoes) {
            binding.data = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemShoesGridBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun getItemCount(): Int {
        return shoes.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(shoes[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(list: List<Shoes>) {
        shoes.clear()
        shoes.addAll(list)
        notifyDataSetChanged()
    }
}