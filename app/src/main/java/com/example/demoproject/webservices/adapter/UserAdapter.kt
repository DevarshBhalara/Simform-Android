package com.example.demoproject.webservices.adapter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.demoproject.databinding.ItemDisplayUserBinding
import com.example.demoproject.webservices.data.Data
import com.example.demoproject.webservices.data.User
import java.net.URL

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    val users: MutableList<Data> = mutableListOf()

    class ViewHolder(private val binding: ItemDisplayUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Data) {
            binding.user = user
            Glide.with(binding.root.context)
                .load(user.avatar)
                .circleCrop()
                .into(binding.imgAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDisplayUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(list: List<Data>) {
        users.clear()
        users.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return users.size
    }

}