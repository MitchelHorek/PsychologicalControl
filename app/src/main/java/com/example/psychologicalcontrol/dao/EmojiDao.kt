package com.example.psychologicalcontrol.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.psychologicalcontrol.entities.Emoji

@Dao
interface EmojiDao {
    @Query ("SELECT * FROM emoji WHERE id_user = :idUser AND date = :date")
    fun getEmojiByDate (idUser: Int, date: String)
    @Insert
    fun insertEmoji (emoji: Emoji)
}