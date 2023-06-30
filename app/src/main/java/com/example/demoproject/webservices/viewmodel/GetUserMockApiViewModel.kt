package com.example.demoproject.webservices.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.activityintent.navgraph.User
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.data.UserTodo
import com.example.demoproject.webservices.repository.UserListRepository
import com.example.demoproject.webservices.retrofitinstance.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class GetUserMockApiViewModel @Inject constructor(
    private val userRepository: UserListRepository
) : ViewModel() {
    private var _userList = MutableLiveData<List<UserMockApi>>()
    var userList: LiveData<List<UserMockApi>> = _userList

    private var _todoList = MutableLiveData<List<UserTodo>>()
    var todoList: LiveData<List<UserTodo>> = _todoList

    fun getAllUser() {
        userRepository.userList.observeForever() {
            _userList.postValue(it)
        }

        userRepository.todoList.observeForever() {
            _todoList.postValue(it)
        }
        viewModelScope.launch {

            userRepository.getUsers()

        }

//        viewModelScope.launch(Dispatchers.IO) {
//
//            val response = RetrofitInstance.getMockApiUser.getUsers()
//            val usersResponse = async {
//                withContext(Dispatchers.Main) {
//                    _userList.postValue(response.body())
//                    _userList
//                }
//            }
//            val users = usersResponse.await()
//
//            launch {
//                for (i in 1 until (users.value?.count() ?: 0)) {
//
//                    responseTodo =  users.value?.get(i)?.id?.let { RetrofitInstance.getUserTodo.getTodo(it) }
//                    Log.d("responseTodo", responseTodo?.body().toString())
//                    responseTodo?.body()?.let {
//                        todoListLocal.add(it)
//                    }
//                }
//                _todoList.postValue(todoListLocal)
//            }
//        }
    }
}