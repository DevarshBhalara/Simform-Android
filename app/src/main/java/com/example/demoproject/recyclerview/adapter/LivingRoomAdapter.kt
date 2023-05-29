package com.example.demoproject.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ItemLivingRoomRecyclerViewBinding
import com.example.demoproject.ktscreen.model.LivingRoomCardModel

class LivingRoomAdapter: RecyclerView.Adapter<LivingRoomAdapter.ViewHolder>() {

    private val devices: MutableList<LivingRoomCardModel> = mutableListOf()

    class ViewHolder(private val binding: ItemLivingRoomRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(devices: LivingRoomCardModel) {
            binding.cardData = devices
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLivingRoomRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return devices.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(devices[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(list: List<LivingRoomCardModel>){
        devices.clear()
        devices.addAll(list)
        notifyDataSetChanged()
    }
}