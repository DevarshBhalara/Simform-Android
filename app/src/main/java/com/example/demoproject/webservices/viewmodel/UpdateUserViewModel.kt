package com.example.demoproject.webservices.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.webservices.data.User
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.repository.UserListRepository
import com.example.demoproject.webservices.retrofitinstance.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class UpdateUserViewModel @Inject constructor(
    private val userRepository: UserListRepository
): ViewModel() {

    private var _user: MutableLiveData<UserMockApi> = MutableLiveData(null)
    var user: LiveData<UserMockApi> = _user

    private var _updatedUser: MutableLiveData<UserMockApi> = MutableLiveData(null)
    var updatedUser: LiveData<UserMockApi> = _updatedUser

    private var _deletedUser: MutableLiveData<UserMockApi> = MutableLiveData(null)
    var deletedUser: LiveData<UserMockApi> = _deletedUser

    fun getUser(id: String) {
        viewModelScope.launch {
            userRepository.getOneUser(id)

            userRepository.getUser.observeForever {
                _user.postValue(it)
            }
        }
    }

    fun updateUser(user: UserMockApi) {
        viewModelScope.launch {
            userRepository.updateUser(user)

            userRepository.updatedUser.observeForever { user ->
                _updatedUser.postValue(user)
            }
        }
    }

    fun deleteUser(userId: String) {
        viewModelScope.launch {
            userRepository.deleteUser(userId)

            userRepository.deleteUser.observeForever {
                _deletedUser.postValue(it)
            }
        }
    }

//    fun deleteUser(userId: String) {
//        RetrofitInstance.getMockApiUser.deleteUser(userId).enqueue(object : Callback<UserMockApi>{
//            override fun onResponse(call: Call<UserMockApi>, response: Response<UserMockApi>) {
//                Log.e("delete", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<UserMockApi>, t: Throwable) {
//                Log.e("delete", t.toString())
//            }
//
//        })
//    }
}