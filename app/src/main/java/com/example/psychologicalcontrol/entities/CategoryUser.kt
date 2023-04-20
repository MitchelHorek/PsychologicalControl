package com.example.psychologicalcontrol.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity (tableName = "category_user",
    foreignKeys = [ForeignKey(
        entity = User::class,
        childColumns = ["id_user"],
        parentColumns = ["id"]
    ),
        ForeignKey(
            entity = Category::class,
            childColumns = ["id_category"],
            parentColumns = ["id"]
        )
    ])
data class CategoryUser (
    @ColumnInfo(name = "id_user") val idUser: Int,
    @ColumnInfo(name = "id_category") val idCategory: Int
    )