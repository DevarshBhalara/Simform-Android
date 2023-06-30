package com.example.demoproject.webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityDisplayUserBinding
import com.example.demoproject.webservices.adapter.UserAdapter
import com.example.demoproject.webservices.viewmodel.GetUserViewModel

class ActivityDisplayUser : AppCompatActivity() {
    lateinit var binding: ActivityDisplayUserBinding
    lateinit var viewModel: GetUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
    }

    private fun setUpUI() {
        viewModel = ViewModelProvider(this)[GetUserViewModel::class.java]
        viewModel.getUser()
        val userAdapter = UserAdapter()

        viewModel.userLiveData.observe(this) {
            Log.e("users", viewModel.userLiveData.value.toString())
            viewModel.userLiveData.value?.let { userAdapter.addItem(it) }
            binding.rvUsers.adapter = userAdapter
        }

    }
}