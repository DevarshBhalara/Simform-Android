package com.example.demoproject.webservices.newsapp.ui

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityNewsBinding
import com.example.demoproject.webservices.newsapp.ui.adapter.NewsAdapter
import com.example.demoproject.webservices.newsapp.ui.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityNews : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels()
    lateinit var binding: ActivityNewsBinding

    companion object {
        private const val LOCATION_PERMISSION_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpObserver()
        setUpPermissions(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_CODE )
        viewModel.getNews()
    }

    private fun setUpObserver() {
        val adapter = NewsAdapter()
        binding.rvNews.adapter = adapter
        viewModel.news.observe(this) {
            Log.d("news", it.articles.size.toString())
            adapter.addNews(it.articles)
        }
    }

    private fun setUpPermissions(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("permission","Permission Granted")
            } else {
                Log.d("permission", "Permission Denied")
            }
        }
    }
}