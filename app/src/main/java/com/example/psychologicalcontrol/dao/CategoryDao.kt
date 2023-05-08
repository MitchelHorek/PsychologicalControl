package com.example.psychologicalcontrol.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.psychologicalcontrol.entities.Category
import com.example.psychologicalcontrol.entities.Task

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category WHERE id = :id")
    suspend fun getCategory(id:Int): Category?
    @Insert
    suspend fun insertCategory(category: Category)

}