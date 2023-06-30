package com.example.demoproject.webservices.interfaces

import com.example.demoproject.webservices.data.AddUserMockApi
import com.example.demoproject.webservices.data.ImageResponse
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.data.UserTodo
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface UserMockApiService {

    @GET("api/users")
    suspend fun getUsers(): Response<ArrayList<UserMockApi>>

    @POST("api/users")
    fun addUser(@Body user: AddUserMockApi): Call<UserMockApi>

    @GET("api/users/{Id}")
    fun getUser(@Path("Id") userId: String): Call<UserMockApi>

    @GET("api/users/{Id}")
    suspend fun getOneUser(@Path("Id") userId: String): Response<UserMockApi>

    @PUT("api/users/{Id}")
    suspend fun updateUser(@Path("Id") userId: String, @Body user: UserMockApi): Response<UserMockApi>

    @DELETE("api/users/{Id}")
    fun deleteUser(@Path("Id") userId: String): Call<UserMockApi>

    @DELETE("api/users/{Id}")
    suspend fun deleteOneUser(@Path("Id") userId: String): Response<UserMockApi>

    @GET("todos/{id}")
    suspend fun getTodo(@Path("id") todoId: String): Response<UserTodo>

    @Multipart
    @POST("upload")
    suspend fun uploadImage(@Query("key") key: String, @Part image: MultipartBody.Part): ImageResponse

    @GET
    suspend fun downloadFile(@Url url: String): ResponseBody
}