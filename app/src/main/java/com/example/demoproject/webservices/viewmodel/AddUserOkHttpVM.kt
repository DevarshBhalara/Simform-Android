package com.example.demoproject.webservices.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.webservices.data.AddUserMockApi
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.ui.AddUserOkHttp
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class AddUserOkHttpVM: ViewModel() {

    private var _validationError = MutableLiveData<String>()
    var validationError: LiveData<String> = _validationError

    private var _response = MutableLiveData<UserMockApi>()
    var response: LiveData<UserMockApi> = _response

    fun validate(name: String, email: String, mobileNumber: String, state: String) {
        if (name.isEmpty()) {
            _validationError.value = "Name is Empty"
        } else if (email.isEmpty()) {
            _validationError.value = "email is Empty"
        } else {
            addUser(AddUserMockApi(name, email, mobileNumber, state))
        }
    }

    fun addUser(user: AddUserMockApi) {
        val gson = Gson()
        val bodyString = gson.toJson(user)
        val body: RequestBody = bodyString.toRequestBody("application/json".toMediaTypeOrNull())

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://648c3d218620b8bae7ec85b9.mockapi.io/users")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("response", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                var user = UserMockApi()
                response.body?.let { responseString ->

                    val jsonData = JSONObject(responseString.string())
                    user = UserMockApi(
                        jsonData.getString("createdAt"),
                        jsonData.getString("name"),
                        jsonData.getString("avatar"),
                        jsonData.getString("email"),
                        jsonData.getString("mobilenumber"),
                        jsonData.getString("state"),
                        jsonData.getString("id"),
                    )

                }
                _response.postValue(user)
            }

        })

    }
}