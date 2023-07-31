package com.example.demoproject.roomdb.repository

import androidx.room.Room
import com.example.demoproject.roomdb.room.User
import com.example.demoproject.roomdb.room.UserDao
import com.example.demoproject.roomdb.room.UserDatabase
import com.example.demoproject.roomdb.ui.InsertUserActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class UserRepository(private val userDao: UserDao) {

    fun insertUser(user: User) {
        userDao.insertAll(user)
    }

    suspend fun getAllUser() = flow<List<User>> {
        emit(userDao.getAll())
    }.flowOn(Dispatchers.IO)
}