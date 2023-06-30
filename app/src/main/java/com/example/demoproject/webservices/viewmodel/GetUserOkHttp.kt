package com.example.demoproject.webservices.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.webservices.data.User
import com.example.demoproject.webservices.data.UserMockApi
import com.google.gson.Gson
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class GetUserOkHttp: ViewModel() {

    private val _users = MutableLiveData<List<UserMockApi>>()
    var users: LiveData<List<UserMockApi>> = _users


    fun getUser() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://648c3d218620b8bae7ec85b9.mockapi.io/users").build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("response", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
//                response.body?.let { Log.d("response", it.string()) }

                val usersList = ArrayList<UserMockApi>()
                val jsonData = response.body?.string()
                val jsonArray = JSONArray(jsonData)
                Log.d("json", jsonArray.toString())

                for(i in 0 until jsonArray.length()) {
                    usersList.add(
                        UserMockApi(
                            jsonArray.getJSONObject(i).getString("createdAt"),
                            jsonArray.getJSONObject(i).getString("name"),
                            jsonArray.getJSONObject(i).getString("avatar"),
                            jsonArray.getJSONObject(i).getString("email"),
                            jsonArray.getJSONObject(i).getString("mobilenumber"),
                            jsonArray.getJSONObject(i).getString("state"),
                            jsonArray.getJSONObject(i).getString("id"),
                        )
                    )
                }
                _users.postValue(usersList)
                Log.d("model", users.toString())
            }

        })

    }
}