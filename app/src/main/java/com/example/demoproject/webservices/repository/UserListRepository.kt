package com.example.demoproject.webservices.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoproject.webservices.data.User
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.data.UserTodo
import com.example.demoproject.webservices.interfaces.UserMockApiService
import kotlinx.coroutines.*
import retrofit2.Response
import java.lang.Exception
import java.net.SocketTimeoutException

class UserListRepository(
    private val userMockApiService: UserMockApiService,
    private val userTodoService: UserMockApiService
) {

    //Get all user and user Todo variable
    private var _userList = MutableLiveData<List<UserMockApi>>()
    var userList: LiveData<List<UserMockApi>> = _userList

    private var _todoList = MutableLiveData<List<UserTodo>>()
    var todoList = _todoList

    var responseTodo: Response<UserTodo>? = null
    var todoListLocal = mutableListOf<UserTodo>()

    //Get User and Update user variables
    private var _getUser = MutableLiveData<UserMockApi>()
    var getUser: LiveData<UserMockApi> = _getUser

    private var _updatedUser: MutableLiveData<UserMockApi> = MutableLiveData(null)
    var updatedUser: LiveData<UserMockApi> = _updatedUser

    //Delete user variables
    private var _deleteUser: MutableLiveData<UserMockApi> = MutableLiveData(null)
    var deleteUser: LiveData<UserMockApi> = _deleteUser


    suspend fun getUsers() {
        try {
            val response = userMockApiService.getUsers()
            if (response.errorBody() == null) {
                _userList.postValue(response.body())

                val users = response.body()

                coroutineScope {
                    launch {
                        for (i in 0 until (users?.count() ?: 0)) {
                            responseTodo = users?.get(i)?.id?.let { userTodoService.getTodo(it) }
                            Log.d("responseTodo", responseTodo?.body().toString())
                            responseTodo?.body()?.let {
                                todoListLocal.add(it)
                            }
                            _todoList.postValue(todoListLocal)
                        }
                    }
                }
            } else {
                Log.d("user", response.errorBody().toString())
            }
        } catch (e: Exception) {
            Log.e("time", e.message.toString())
        }


//        val userResponse = coroutineScope {
//            async {
//                _userList.postValue(response.body())
//                _userList
//            }
//        }

    }

    suspend fun getOneUser(id: String) {
        val response = userMockApiService
            .getOneUser(id)

        if (response.isSuccessful) {
            response.body()?.let {user ->
                _getUser.postValue(user)
            }
        } else {
            Log.e("user", response.errorBody().toString())
        }
    }

    suspend fun updateUser(user: UserMockApi) {
        user.id?.let {id ->
            val response = userMockApiService.updateUser(id, user)
            if (response.isSuccessful) {
                response.body()?.let { user ->
                    _updatedUser.postValue(user)
                }
            } else {
                Log.d("user", response.errorBody().toString())
            }
        }
    }

    suspend fun deleteUser(id: String) {
        val response = userMockApiService.deleteOneUser(id)
        if (response.isSuccessful) {
            response.body()?.let { user ->
                _deleteUser.postValue(user)
            }
        } else {
            Log.e("user", response.errorBody().toString())
        }
    }


}


