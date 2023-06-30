package com.example.demoproject.webservices.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.webservices.data.LoginRequest
import com.example.demoproject.webservices.data.LoginResponse
import com.example.demoproject.webservices.retrofitinstance.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserLoginViewModel: ViewModel() {
    private val _loginResponse: MutableLiveData<LoginResponse?> = MutableLiveData(null)
    var loginresponse: LiveData<LoginResponse?> = _loginResponse

    fun loginUser(name: String, job: String) {

        RetrofitInstance.getUserApi.createUser(LoginRequest(name,job)).enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                Log.e("Login", response.body().toString())
                _loginResponse.value = response.body()
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Log.e("Login", "Fail")
            }
        })
    }
}