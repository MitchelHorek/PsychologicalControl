package com.example.psychologicalcontrol.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.psychologicalcontrol.entities.Emoji

@Dao
interface EmojiDao {
    @Query ("SELECT * FROM emoji WHERE id_user = :idUser AND date = :date")
    suspend fun getEmojiByDate (idUser: Int, date: String): Emoji
    @Insert
    suspend fun insertEmoji (emoji: Emoji)
}