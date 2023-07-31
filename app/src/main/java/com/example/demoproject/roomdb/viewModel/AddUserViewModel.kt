package com.example.demoproject.roomdb.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.roomdb.repository.UserRepository
import com.example.demoproject.roomdb.room.User
import com.example.demoproject.roomdb.room.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    var user = _users.asStateFlow()

    fun insertUser(user: User) {
        repository.insertUser(user)
    }

    fun getAllUser() {
        viewModelScope.launch {
            repository.getAllUser().collectLatest {
                _users.emit(it)
                Log.d("usersVM", it.toString())
            }
        }
    }
}