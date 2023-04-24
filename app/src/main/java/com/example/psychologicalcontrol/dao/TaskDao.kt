package com.example.psychologicalcontrol.dao

import androidx.room.*
import com.example.psychologicalcontrol.entities.Task
import com.example.psychologicalcontrol.entities.User

@Dao
interface TaskDao {
    @Query("SELECT * FROM task WHERE id_user = :idUser")
    fun getAll(idUser:Int): List <Task>
    @Query("SELECT * FROM task WHERE id_user = :idUser AND id_category = :idCategory")
    fun getAllByCategory(idUser: Int, idCategory:Int)
    @Query("SELECT * FROM task WHERE id_user = :idUser AND date = :date")
    fun getAllByDate(idUser: Int, date: String)
    @Insert
    fun insertTask(vararg task: Task)
    @Delete
    fun deleteTask(task: Task)
    @Update
    fun updateTask(task: Task)


}