package com.example.demoproject.webservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityLoginBinding
import com.example.demoproject.webservices.data.LoginResponse
import com.example.demoproject.webservices.viewmodel.UserLoginViewModel

class ActivityLogin : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private val viewModel: UserLoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.loginresponse.observe(this) {
            it?.let(this::showAlertDialog)
        }
        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        viewModel.loginUser(binding.edName.text.toString(), binding.edJob.text.toString())
    }

    private fun showAlertDialog(loginResponse: LoginResponse?) {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Account Created")
        builder.setMessage("Welcome " + loginResponse?.name)

        builder.setNegativeButton("OK") { dialogInterface, _ ->
            dialogInterface.cancel()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}