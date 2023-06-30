package com.example.demoproject.webservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityDisplayMockApiUsersBinding
import com.example.demoproject.webservices.adapter.UserMockApiAdapter
import com.example.demoproject.webservices.data.UserTodoLocal
import com.example.demoproject.webservices.viewmodel.GetUserMockApiViewModel
import com.example.demoproject.webservices.viewmodel.UserLoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityDisplayMockApiUsers : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayMockApiUsersBinding
    private val viewModel: GetUserMockApiViewModel by viewModels()
    var userTodoLocal: UserTodoLocal = UserTodoLocal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayMockApiUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
        displayUser()

    }

    private fun setUpUI() {
        binding.btnAddUser.setOnClickListener {
            val intent = Intent(this, ActivityAddUser::class.java)
            startActivity(intent)
        }
    }

    private fun displayUser() {

        viewModel.getAllUser()
        val adapter = UserMockApiAdapter()

        binding.rvUsers.adapter = adapter

        viewModel.userList.observe(this) { user ->
           userTodoLocal.user = user
            binding.loading.visibility = View.GONE
            adapter.addUser(userTodoLocal)
        }

        viewModel.todoList.observe(this) {
            todo ->
            userTodoLocal.todos = todo
            adapter.addUser(userTodoLocal)
        }

    }
}