package com.example.demoproject.roomdb.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertAll(vararg users: User): List<Long>

    @Query("select * from users")
    suspend fun getAll(): List<User>

    @Delete
    suspend fun delete(user: User): Int

    @Update
    suspend fun update(user: User): Int
}