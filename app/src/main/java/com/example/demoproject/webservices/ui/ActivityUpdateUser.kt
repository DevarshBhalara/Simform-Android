package com.example.demoproject.webservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.demoproject.databinding.ActivityUpdateUserBinding
import com.example.demoproject.webservices.data.LoginResponse
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.viewmodel.UpdateUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityUpdateUser : AppCompatActivity() {

    lateinit var binding: ActivityUpdateUserBinding
    private val viewModel: UpdateUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
    }

    private fun setUpUI() {
        val intent = intent
        val id = intent.getStringExtra("ID")

        if (id != null) {
            viewModel.getUser(id)
        }

        viewModel.user.observe(this) { user ->
            binding.user = user
        }
        viewModel.deletedUser.observe(this) {
            if (it != null) {
                Toast.makeText(this, binding.tfUserName.text.toString() + " Deleted successfully!", Toast.LENGTH_SHORT).show()
                navigationToHome()
            }
        }

        binding.updateUser.setOnClickListener {
            updateUser()
        }

        binding.deleteUser.setOnClickListener {
            deleteUser()
        }
    }

    private fun updateUser() {
        viewModel.updateUser(
            UserMockApi(
                id = binding.tfId.text.toString(),
                name = binding.tfUserName.text.toString(),
                email = binding.tfEmail.text.toString(),
                mobilenumber = binding.tfMobile.text.toString(),
                state = binding.tfState.text.toString()
            )
        )
        viewModel.updatedUser.observe(this) {
            navigationToHome()
        }
    }

    private fun navigationToHome() {
        val intent = Intent(this, ActivityDisplayMockApiUsers::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

    private fun deleteUser() {
        showAlertDialog()
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("User")
        builder.setMessage("Are you sure you want to delete this user?")

        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteUser(binding.tfId.text.toString())

        }

        builder.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.cancel()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}