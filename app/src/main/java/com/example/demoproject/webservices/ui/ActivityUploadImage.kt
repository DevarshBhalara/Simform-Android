package com.example.demoproject.webservices.ui

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.demoproject.R
import com.example.demoproject.ToastDemo
import com.example.demoproject.databinding.ActivityUpdateUserBinding
import com.example.demoproject.databinding.ActivityUploadImageBinding
import com.example.demoproject.webservices.viewmodel.UploadImageViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

@AndroidEntryPoint
class ActivityUploadImage : AppCompatActivity() {

    lateinit var binding: ActivityUploadImageBinding
    lateinit var imageUri: Uri
    private val viewModel: UploadImageViewModel by viewModels()
    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it != null) {
            imageUri = it
            binding.imageView.setImageURI(it)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
    }

    @SuppressLint("Recycle")
    private fun setUpUI() {

        viewModel.imageResponse.observe(this) {
            Toast.makeText(this, "Image Uploaded Successfully!!", Toast.LENGTH_SHORT).show()
        }

        binding.btnSelectImage.setOnClickListener {
            contract.launch("image/*")
        }

        binding.btnUploadImage.setOnClickListener {
            val filesDir = applicationContext.filesDir
            val file = File(filesDir, "image.png")

            val inputStream = contentResolver.openInputStream(imageUri)
            val outputStream = FileOutputStream(file)
            inputStream?.copyTo(outputStream)

            viewModel.uploadImage(file)
        }
    }
}