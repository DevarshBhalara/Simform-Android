package com.example.demoproject.webview

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.demoproject.databinding.ActivityWebViewBinding

class ActivityWebView : AppCompatActivity() {
    lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpWebView()
    }

    private fun setUpWebView() {
        val webViewSetting = binding.webView.settings
        webViewSetting.javaScriptEnabled = true
        val webViewClient = MyWebViewClient()
        binding.webView.webViewClient = webViewClient
        binding.webView.loadUrl("https://www.google.com")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}