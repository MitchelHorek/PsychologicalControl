package com.example.psychologicalcontrol.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.psychologicalcontrol.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id = :userId")
    suspend fun getUserById(userId: Int): User
    @Insert
    suspend fun insertUser(vararg user: User)

}