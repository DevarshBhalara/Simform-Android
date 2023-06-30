package com.example.demoproject.webservices.interfaces

import com.example.demoproject.webservices.data.LoginRequest
import com.example.demoproject.webservices.data.LoginResponse
import com.example.demoproject.webservices.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApiServices {

    @GET("/api/users")
    fun getUsers(@Query("page") page: String): Call<User>

    @POST("/api/users")
    fun createUser(@Body user: LoginRequest ): Call<LoginResponse>
}