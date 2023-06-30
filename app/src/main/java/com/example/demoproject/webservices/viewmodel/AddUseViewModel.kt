package com.example.demoproject.webservices.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.webservices.data.AddUserMockApi
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.retrofitinstance.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddUseViewModel: ViewModel() {


    private val _addResponse: MutableLiveData<UserMockApi?> = MutableLiveData(null)
    val addResponse: LiveData<UserMockApi?> = _addResponse

    private val _error: MutableLiveData<String> = MutableLiveData("")
    val error: LiveData<String> = _error

    private val _validationError: MutableLiveData<String> = MutableLiveData("")
    val validationError: LiveData<String> = _validationError

    fun validation(name: String, email: String, mobileNumber: String, state: String ) {
        if (name.isEmpty()) {
            _validationError.value = "Name is Empty"
        } else if (email.isEmpty()) {
            _validationError.value = "Email is empty"
        } else if (mobileNumber.isEmpty()) {
            _validationError.value = "Mobile number is Empty"
        } else if (state.isEmpty()) {
            _validationError.value = "State is Empty"
        } else {
            addUserApi(AddUserMockApi(name, email, mobileNumber, state))
        }
    }

    private fun addUserApi(user: AddUserMockApi) {
        RetrofitInstance.getMockApiUser.addUser(user).enqueue(object : Callback<UserMockApi>{
            override fun onResponse(call: Call<UserMockApi>, response: Response<UserMockApi>) {
                _addResponse.value = response.body()
            }

            override fun onFailure(call: Call<UserMockApi>, t: Throwable) {
                _error.value = t.toString()
            }

        })
    }


}