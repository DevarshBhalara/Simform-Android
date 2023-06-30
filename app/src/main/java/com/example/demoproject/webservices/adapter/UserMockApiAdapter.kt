package com.example.demoproject.webservices.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoproject.databinding.ItemUserMockApiBinding
import com.example.demoproject.webservices.data.Data
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.data.UserTodo
import com.example.demoproject.webservices.data.UserTodoLocal
import com.example.demoproject.webservices.ui.ActivityUpdateUser

class UserMockApiAdapter: RecyclerView.Adapter<UserMockApiAdapter.ViewHolder>() {

//    val users: MutableList<UserMockApi> = mutableListOf()
//    val todos: MutableList<UserTodo> = mutableListOf()

    val users: UserTodoLocal = UserTodoLocal()

    class ViewHolder(private val binding: ItemUserMockApiBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserMockApi, todos: UserTodo) {
            binding.user = user
            binding.todo = todos
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
    ): ViewHolder {
        return ViewHolder(ItemUserMockApiBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("size", "" + users.user?.size + " " + users.todos?.size)
        holder.bind(users.user?.get(position) ?: UserMockApi(), users.todos?.getOrNull(position) ?: UserTodo())
    }

    override fun getItemCount(): Int {
        return users.user?.size ?: 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addUser(list: UserTodoLocal) {
        users.user = list.user
        users.todos = list.todos
        notifyDataSetChanged()
    }
}