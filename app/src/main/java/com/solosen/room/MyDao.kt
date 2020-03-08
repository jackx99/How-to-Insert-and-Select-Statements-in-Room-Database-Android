package com.solosen.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDao {

    @Insert
    suspend fun createUser(user: User)

    @Query("SELECT * FROM User")
    suspend fun getUser(): User
}