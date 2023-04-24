package com.example.psychologicalcontrol.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "task",
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
data class Task (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "id_user") val idUser: Int,
    @ColumnInfo(name = "id_category") val idCategory: Int,
    @ColumnInfo(name = "complete") val complete: Boolean
)