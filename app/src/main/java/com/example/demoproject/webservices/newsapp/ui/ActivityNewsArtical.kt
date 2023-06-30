package com.example.demoproject.webservices.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityNewsArticalBinding
import com.example.demoproject.webview.MyWebViewClient

class ActivityNewsArtical : AppCompatActivity() {

    lateinit var binding: ActivityNewsArticalBinding
    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsArticalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
    }

    private fun setUpUI() {
        val webViewSetting = binding.webView.settings
        webViewSetting.javaScriptEnabled = true
        val intent = intent.extras
        url = intent?.getString("url", "") ?: ""
        binding.webView.loadUrl(url)
    }
}