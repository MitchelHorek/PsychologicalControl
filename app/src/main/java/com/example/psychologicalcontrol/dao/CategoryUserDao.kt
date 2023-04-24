package com.example.psychologicalcontrol.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface CategoryUserDao {
    @Query ("DELETE FROM category_user WHERE id_category = :idCategory AND id_user = :idUser")
    fun deleteCategory (idCategory: Int, idUser: Int)

}