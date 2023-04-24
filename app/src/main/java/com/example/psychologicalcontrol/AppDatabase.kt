package com.example.psychologicalcontrol

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.psychologicalcontrol.dao.*
import com.example.psychologicalcontrol.entities.*

@Database(entities = [User::class, Category::class, CategoryUser::class, Emoji::class, Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun categoryDao(): CategoryDao
    abstract fun categoryUserDao(): CategoryUserDao
    abstract fun emojiDao(): EmojiDao
    abstract fun taskDao(): TaskDao
}