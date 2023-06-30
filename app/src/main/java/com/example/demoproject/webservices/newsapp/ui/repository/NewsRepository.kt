package com.example.demoproject.webservices.newsapp.ui.repository

import com.example.demoproject.webservices.newsapp.ui.model.News
import com.example.demoproject.webservices.newsapp.ui.retrofit.NewsInterface

class NewsRepository (private val newsService: NewsInterface) {


    suspend fun getNews(): News? {
        return newsService.getNews().body()
    }
}