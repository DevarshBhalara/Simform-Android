package com.example.demoproject.webservices.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.webservices.data.Data
import com.example.demoproject.webservices.data.User
import com.example.demoproject.webservices.retrofitinstance.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserViewModel: ViewModel() {
    private var _userLiveData = MutableLiveData<List<Data>>()
    var userLiveData: LiveData<List<Data>> = _userLiveData

    fun getUser() {
        RetrofitInstance.getUserApi.getUsers("2").enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                val a = response.body()?.data
                _userLiveData.value = response.body()?.data
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                Log.d("users", "failll")
            }
        })
    }
}