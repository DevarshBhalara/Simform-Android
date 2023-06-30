package com.example.demoproject.webservices.newsapp.ui.retrofit

import com.example.demoproject.webservices.newsapp.ui.model.News
import retrofit2.Response
import retrofit2.http.GET

interface NewsInterface {
    @GET("top-headlines?country=in&apiKey=67962f7b55de4aa7b22b2307d8c4d73d&pageSize=80")
    suspend fun getNews(): Response<News>
}