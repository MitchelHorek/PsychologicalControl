package com.example.psychologicalcontrol.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.psychologicalcontrol.entities.CategoryUser

@Dao
interface CategoryUserDao {
    @Insert
    suspend fun insertCategoryUser(categoryUser: CategoryUser)
    @Query("SELECT id_category FROM category_user WHERE id_user = :id_user")
    suspend fun getCategoriesByUser(id_user:Int):List<Int>
    @Query ("DELETE FROM category_user WHERE id_category = :idCategory AND id_user = :idUser")
    suspend fun deleteCategory (idCategory: Int, idUser: Int)

}