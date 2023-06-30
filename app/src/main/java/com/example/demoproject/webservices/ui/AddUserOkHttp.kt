package com.example.demoproject.webservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.demoproject.databinding.ActivityAddUserBinding
import com.example.demoproject.webservices.data.AddUserMockApi
import com.example.demoproject.webservices.viewmodel.AddUserOkHttpVM

class AddUserOkHttp : AppCompatActivity() {

    lateinit var binding: ActivityAddUserBinding
    private val viewModel: AddUserOkHttpVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpObserver()
        binding.addUser.setOnClickListener {
            addUser()
        }

    }

    private fun setUpObserver() {
        viewModel.validationError.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.response.observe(this) {
            Toast.makeText(this, "User Added Successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ActivityDisplayUserOkHttp::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

    }

    private fun addUser() {
        viewModel.validate(binding.tfUserName.text.toString(),binding.tfEmail.text.toString(), binding.tfMobile.text.toString(), binding.tfState.text.toString())
    }
}