package com.example.demoproject.webservices.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoproject.databinding.ItemDisplayUserBinding
import com.example.demoproject.databinding.ItemUserMockApiBinding
import com.example.demoproject.webservices.data.Data
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.ui.ActivityUpdateUser

class UserAdapterOkHttp: RecyclerView.Adapter<UserAdapterOkHttp.ViewHolder>() {
    val users: MutableList<UserMockApi> = mutableListOf()

    class ViewHolder(private val binding: ItemUserMockApiBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserMockApi) {
            binding.user = user
            Glide.with(binding.root.context)
                .load(user.avatar)
                .circleCrop()
                .into(binding.imgAvatar)

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, ActivityUpdateUser::class.java)
                intent.putExtra("ID", user.id)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapterOkHttp.ViewHolder {
        return ViewHolder(
            ItemUserMockApiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserAdapterOkHttp.ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addUser(list: List<UserMockApi>) {
        users.clear()
        users.addAll(list)
        notifyDataSetChanged()
    }
}