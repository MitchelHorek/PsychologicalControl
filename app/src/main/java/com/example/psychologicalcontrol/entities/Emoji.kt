package com.example.psychologicalcontrol.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity (tableName = "emoji",
    foreignKeys = [
        ForeignKey(
    entity = User::class,
    childColumns = ["id_user"],
    parentColumns = ["id"]
    )]
)
data class Emoji (
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "id_user") val idUser: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "value") val value: Int,
)