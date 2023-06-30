package com.example.demoproject.webservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityDownloadFileBinding
import com.example.demoproject.webservices.viewmodel.DownloadFileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityDownloadFile : AppCompatActivity() {

    lateinit var binding: ActivityDownloadFileBinding
    private val viewModel: DownloadFileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadFileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.downloadFile()
    }
}