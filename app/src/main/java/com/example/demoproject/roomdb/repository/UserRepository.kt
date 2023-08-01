package com.example.demoproject.roomdb.repository

import com.example.demoproject.roomdb.room.User
import com.example.demoproject.roomdb.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User) = flow<Boolean> {
        val id = userDao.insertAll(user)
        emit(id.first() > 0)
    }.flowOn(Dispatchers.IO)

    suspend fun getAllUser() = flow<List<User>> {
        emit(userDao.getAll())
    }.flowOn(Dispatchers.IO)

    suspend fun deleteUser(user: User) = flow<Boolean> {
        val id = userDao.delete(user)
        emit(id > 0)
    }.flowOn(Dispatchers.IO)

    suspend fun updateUser(user: User) = flow<Boolean> {
        val id = userDao.update(user)
        emit(id > 0)
    }.flowOn(Dispatchers.IO)
}