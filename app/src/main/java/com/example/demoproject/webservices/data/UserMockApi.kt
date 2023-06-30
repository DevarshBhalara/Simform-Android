package com.example.demoproject.webservices.data

import com.google.gson.annotations.SerializedName

data class UserMockApi(
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("mobilenumber") var mobilenumber: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("id") var id: String? = null
)

data class UserTodoLocal(
    var user: List<UserMockApi>? = null,
    var todos: List<UserTodo>? = null
)

data class AddUserMockApi(
    @SerializedName("name") var name: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("mobilenumber") var mobilenumber: String? = null,
    @SerializedName("state") var state: String? = null
)

data class UserTodo(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("todo") var todo: String? = null,
    @SerializedName("completed") var completed: Boolean? = null,
    @SerializedName("userId") var userId: Int? = null

)