package com.example.demoproject.webservices.data

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("page") val page: Int? = null,
    @SerializedName("per_page") val perPage: Int? = null,
    @SerializedName("total") val total: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("data") val data: List<Data> = arrayListOf()

)

data class Data(

    @SerializedName("id") val id: Int? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("first_name") val firstName: String? = null,
    @SerializedName("last_name") val lastName: String? = null,
    @SerializedName("avatar") val avatar: String? = null

)

data class LoginRequest(
    @SerializedName("name") val name: String? = null,
    @SerializedName("job") val job: String? = null,
)

data class LoginResponse(

    @SerializedName("name") val name: String? = null,
    @SerializedName("job") val job: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("createdAt") val createdAt: String? = null

)
