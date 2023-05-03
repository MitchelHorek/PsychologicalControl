package com.example.psychologicalcontrol.dao

import androidx.room.*
import com.example.psychologicalcontrol.entities.Task
import com.example.psychologicalcontrol.entities.User

@Dao
interface TaskDao {
    @Query("SELECT * FROM task WHERE id_user = :idUser")
    suspend fun getAll(idUser:Int): List <Task>
    @Query("SELECT * FROM task WHERE id_user = :idUser AND id_category = :idCategory")
    suspend fun getAllByCategory(idUser: Int, idCategory:Int): List <Task>
    @Query("SELECT * FROM task WHERE id_user = :idUser AND date = :date")
    suspend fun getAllByDate(idUser: Int, date: String): List <Task>
    @Insert
    suspend fun insertTask(vararg task: Task)
    @Delete
    suspend fun deleteTask(task: Task)
    @Update
    suspend fun updateTask(task: Task)


}