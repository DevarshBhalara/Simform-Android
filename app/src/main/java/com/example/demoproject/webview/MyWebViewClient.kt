package com.example.demoproject.webview

import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.demoproject.R

class MyWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        if (request != null) {
            if (Uri.parse(request.url.toString()).host.equals("m.facebook.com")) {
                val unauthorised = view?.resources?.openRawResource(R.raw.error_page)?.readBytes()?.decodeToString() ?: ""
                view?.loadDataWithBaseURL(null, unauthorised, "text/html", "charset=UTF-8", null)
                return false
            }
        }
        return false
    }
}