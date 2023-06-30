package com.example.demoproject.webservices.retrofitinstance

import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.interfaces.UserApiServices
import com.example.demoproject.webservices.interfaces.UserMockApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    val getUserApi: UserApiServices by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiServices::class.java)
    }

    val getMockApiUser: UserMockApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://648c3d218620b8bae7ec85b9.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserMockApiService::class.java)
    }

    val getUserTodo: UserMockApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserMockApiService::class.java)
    }

    val uploadImage: UserMockApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.imgbb.com/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserMockApiService::class.java)
    }
}