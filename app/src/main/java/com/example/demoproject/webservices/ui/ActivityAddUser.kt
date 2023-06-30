package com.example.demoproject.webservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.demoproject.R
import com.example.demoproject.ToastDemo
import com.example.demoproject.databinding.ActivityAddUserBinding
import com.example.demoproject.webservices.data.AddUserMockApi
import com.example.demoproject.webservices.viewmodel.AddUseViewModel
import com.example.demoproject.webservices.viewmodel.GetUserMockApiViewModel

class ActivityAddUser : AppCompatActivity() {

    lateinit var binding: ActivityAddUserBinding
    private val viewModel: AddUseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBind()
        binding.addUser.setOnClickListener{
            addUser()
        }
    }

    private fun setUpBind() {
        viewModel.error.observe(this) {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.validationError.observe(this) {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.addResponse.observe(this) {
            it?.let {
                val intent = Intent(this, ActivityDisplayMockApiUsers::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun addUser() {
        viewModel.validation(
          binding.tfUserName.text.toString(),
            binding.tfEmail.text.toString(),
            binding.tfMobile.text.toString(),
            binding.tfState.text.toString()
        )
    }
}