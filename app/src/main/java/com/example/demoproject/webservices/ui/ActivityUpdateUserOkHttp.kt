package com.example.demoproject.webservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ContentInfoCompat.Flags
import com.example.demoproject.databinding.ActivityUpdateUserBinding
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.viewmodel.UpdateUserOkHttpVM

class ActivityUpdateUserOkHttp : AppCompatActivity() {

    lateinit var binding: ActivityUpdateUserBinding
    private val viewModel: UpdateUserOkHttpVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()

    }

    private fun setUpUI() {

        val id = intent.getStringExtra("ID")
        id?.let { viewModel.getUser(it) }

        viewModel.user.observe(this) { user ->
            binding.user = user
        }

        viewModel.updatedUser.observe(this) {
            val intent = Intent(this, ActivityDisplayUserOkHttp::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        viewModel.isDelete.observe(this) {
            navigationToHome()
        }

        binding.updateUser.setOnClickListener {
            updateUser()
        }

        binding.deleteUser.setOnClickListener {
            showAlertDialog()
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
    }

    private fun navigationToHome() {
        val intent = Intent(this, ActivityDisplayUserOkHttp::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("User")
        builder.setMessage("Are you sure you want to delete this user?")

        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteUser(binding.tfId.text.toString())
            Toast.makeText(this, binding.tfUserName.text.toString() + " Deleted successfully!", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.cancel()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}