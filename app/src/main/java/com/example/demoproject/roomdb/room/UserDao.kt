package com.example.demoproject.roomdb.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun insertAll(vararg users: User)

    @Query("select * from users")
    fun getAll(): List<User>
}