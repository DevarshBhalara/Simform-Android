package com.example.demoproject.roomdb.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demoproject.roomdb.ui.InsertUserActivity
import kotlinx.coroutines.CoroutineScope

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(ctx: InsertUserActivity, scope: CoroutineScope): UserDatabase {
            return when (val temp = INSTANCE) {
                null -> synchronized(this) {
                    Room.databaseBuilder(
                        ctx.applicationContext, UserDatabase::class.java,
                        "user"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                else -> temp
            }
        }
    }
}