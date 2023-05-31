package com.example.demoproject.recyclerview.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ItemLivingRoomRecyclerViewBinding
import com.example.demoproject.ktscreen.model.LivingRoomCardModel

class LivingRoomAdapter: RecyclerView.Adapter<LivingRoomAdapter.ViewHolder>() {


    val appliances: MutableList<LivingRoomCardModel> = mutableListOf()

    inner class ViewHolder(private val binding: ItemLivingRoomRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(devices: LivingRoomCardModel) {
            binding.cardData = devices
            binding.executePendingBindings()
        }

        @SuppressLint("NotifyDataSetChanged")
        fun setRadioClickEvent(position: Int) {
            binding.rdOnOff.setOnClickListener {
                appliances[position].isOn = !appliances[position].isOn
                Log.e("RadioClick", appliances[position].toString())
                notifyItemChanged(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLivingRoomRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return appliances.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("Bind" , appliances[position].toString())
        holder.bind(appliances[position])
        holder.setRadioClickEvent(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(list: List<LivingRoomCardModel>){
        appliances.clear()
        appliances.addAll(list)
        notifyDataSetChanged()
    }
}