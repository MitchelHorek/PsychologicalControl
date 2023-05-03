package com.example.psychologicalcontrol

import android.content.Context
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.psychologicalcontrol.entities.Category
import kotlinx.coroutines.launch

class DatabaseHelper {

   /* private lateinit var db:AppDatabase
    companion object {
        private var db_:DatabaseHelper? = null
        *//*public fun getInstance(): DatabaseHelper{
            var temp = db_
            if (temp != null){

                return temp


            }
            return synchronized(this) {

                val checkInstanceAgain = db_
                if (checkInstanceAgain != null) {
                    checkInstanceAgain
                } else {
                    db_ = DatabaseHelper()
                    val created = db_

                    created
                }
            }
        }*//*
    }


    private fun createDatabase(applicationContext: Context) {
        print("test")
        Log.d("mainactivity", "test")
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "psychological_control"
        ).build()
        Log.d("mainactivity", "test2")
        createBaseCategories()
        *//*val category = db.categoryDao().getCategory(1)
        Log.d("mainactivity", String.format("%d", category.id))
        print(category.id)
        if(db.categoryDao().getCategory(1) == null){

        }*//*
    }
    private fun createBaseCategories() {
        lifecycleScope.launch {
            val category = db.categoryDao().getCategory(1);
            if category == null{
                insertNewCategory("Лекарства")
                print("!!!create")
            }
            else {
                print("!!!not create")
            }
        }
    }
    public fun insertNewCategory(name: String){
        lifecycleScope.launch {
            val category = Category(0, name)
            db.categoryDao().insertCategory(category)
        }

    }*/

}