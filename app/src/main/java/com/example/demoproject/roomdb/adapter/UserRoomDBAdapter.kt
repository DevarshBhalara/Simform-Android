package com.example.demoproject.roomdb.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ActivityInsertUserBinding
import com.example.demoproject.databinding.ItemRoomDbUserBinding
import com.example.demoproject.roomdb.listners.ItemClickListener
import com.example.demoproject.roomdb.room.User

class UserRoomDBAdapter : RecyclerView.Adapter<UserRoomDBAdapter.ViewHolder>() {

    private var users: MutableList<User> = mutableListOf()
    var itemClickListener: ItemClickListener<User>? = null

    inner class ViewHolder(private val binding: ItemRoomDbUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClickListener?.onClick(
                    users[adapterPosition],
                    adapterPosition
                )
            }
        }

        fun bind(user: User) {
            binding.user = user
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRoomDbUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun getItemCount(): Int = users.count()


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<User>) {
        users.clear()
        users.addAll(list)
        notifyDataSetChanged()
    }
}