package com.example.demoproject.roomdb.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.roomdb.repository.UserRepository
import com.example.demoproject.roomdb.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _insertSuccess = MutableLiveData<String>("")
    val insertSuccess = _insertSuccess

    private val _deleteSuccess = MutableLiveData<String>("")
    val deleteSuccess = _deleteSuccess

    private val _updateSuccess = MutableLiveData<String>("")
    val updateSuccess = _updateSuccess

    private val _users = MutableStateFlow<List<User>>(emptyList())
    var user = _users.asStateFlow()

    private var job: Job? = null

    fun insertUser(user: User) {
        job?.cancel()
       job = viewModelScope.launch {
           repository.insertUser(user).collectLatest {
               Log.d("print", "in VM $it")
               if (it) {
                   _insertSuccess.value = "User added"
               } else {
                   _insertSuccess.value = "fail to add user"
               }
           }
       }
    }

    fun deleteUser(user: User) {
        job?.cancel()
        job = viewModelScope.launch {
            repository.deleteUser(user).collectLatest {
                Log.d("print", "in VM $it")
                if (it) {
                    _deleteSuccess.value = "User Deleted"
                } else {
                    _deleteSuccess.value = "fail to delete user"
                }
            }
        }
    }

    fun updateUser(user: User) {
        job?.cancel()
        job = viewModelScope.launch {
            repository.updateUser(user).collectLatest {
                if (it) {
                    _updateSuccess.value = "User Updated"
                } else {
                    _updateSuccess.value = "User not Updated"
                }
            }
        }
    }

    fun getAllUser() {
        job?.cancel()
        job = viewModelScope.launch {
            repository.getAllUser().collectLatest {
                _users.emit(it)
                Log.d("print U", it.toString())
            }
        }
    }
}