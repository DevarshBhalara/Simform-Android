package com.example.demoproject.webservices.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.webservices.data.AddUserMockApi
import com.example.demoproject.webservices.data.UserMockApi
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class UpdateUserOkHttpVM: ViewModel() {

    private var _isDelete = MutableLiveData<Boolean>()
    var isDelete: LiveData<Boolean> = _isDelete

    private var _user = MutableLiveData<UserMockApi>()
    var user: LiveData<UserMockApi> = _user

    private var _updatedUser = MutableLiveData<UserMockApi>()
    var updatedUser: LiveData<UserMockApi> = _updatedUser

    fun getUser(id: String) {

        val client = OkHttpClient()
        val request = Request.Builder().url("https://648c3d218620b8bae7ec85b9.mockapi.io/users/$id").build()
        client.newCall(request).enqueue(object: Callback {

            override fun onFailure(call: Call, e: IOException) {
                Log.e("response", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {

                response.body?.string()?.let { responseString ->
                    val json = JSONObject(responseString)
                    val userData = UserMockApi(
                        json.getString("createdAt"),
                        json.getString("name"),
                        json.getString("avatar"),
                        json.getString("email"),
                        json.getString("mobilenumber"),
                        json.getString("state"),
                        json.getString("id"),
                    )
                    _user.postValue(userData)
                }
            }
        })
    }

    fun updateUser(user: UserMockApi) {

        val gson = Gson()
        val bodyString = gson.toJson(user)
        val body: RequestBody = bodyString.toRequestBody("application/json".toMediaTypeOrNull())

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://648c3d218620b8bae7ec85b9.mockapi.io/users/$user.id")
            .put(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("fail", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {responseData ->
                    val jsonData = JSONObject(responseData)
                    _user.value = UserMockApi(
                        jsonData.getString("createdAt"),
                        jsonData.getString("name"),
                        jsonData.getString("avatar"),
                        jsonData.getString("email"),
                        jsonData.getString("mobilenumber"),
                        jsonData.getString("state"),
                        jsonData.getString("id"),
                    )
                }
            }
        })
    }

    fun deleteUser(id: String) {

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://648c3d218620b8bae7ec85b9.mockapi.io/users/$id")
            .delete()
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("response", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    _isDelete.value = true
                }
            }
        })
    }
}