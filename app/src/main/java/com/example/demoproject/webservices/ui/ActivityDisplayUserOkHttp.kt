package com.example.demoproject.webservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityDisplayUserOkHttpBinding
import com.example.demoproject.webservices.adapter.UserAdapterOkHttp
import com.example.demoproject.webservices.adapter.UserMockApiAdapter
import com.example.demoproject.webservices.viewmodel.GetUserOkHttp

class ActivityDisplayUserOkHttp : AppCompatActivity() {

    lateinit var binding: ActivityDisplayUserOkHttpBinding
    private val viewModel: GetUserOkHttp by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayUserOkHttpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
    }

    private fun setUpUI() {
        val adapter = UserAdapterOkHttp()
        viewModel.getUser()
        viewModel.users.observe(this) {
            adapter.addUser(it)
            binding.rvUsers.adapter = adapter
        }

        binding.btnAddUser.setOnClickListener {
            val intent = Intent(this, AddUserOkHttp::class.java)
            startActivity(intent)
        }
    }

}