package com.example.demoproject.webservices.interceptor

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class APIInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request().newBuilder().addHeader(
            "Authorization",
            ""
        ).build()

        val response = chain.proceed(request)

        // If response is unauthorized and Authorization header already exist, Logout user.
        if (response.code == 401 && response.header("Authorization") != null) {
            //Handle error
        }

        return response
    }
}