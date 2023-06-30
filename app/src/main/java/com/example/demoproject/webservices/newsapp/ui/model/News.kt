package com.example.demoproject.webservices.newsapp.ui.model

import com.google.gson.annotations.SerializedName

data class News(

    @SerializedName("status") val status: String? = null,
    @SerializedName("totalResults") val totalResults: Int? = null,
    @SerializedName("articles") val articles: ArrayList<Articles> = arrayListOf()

)

data class Source(

    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null

)

data class Articles(

    @SerializedName("source") val source: Source? = Source(),
    @SerializedName("author") val author: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("urlToImage") val urlToImage: String? = null,
    @SerializedName("publishedAt") val publishedAt: String? = null,
    @SerializedName("content") val content: String? = null

)