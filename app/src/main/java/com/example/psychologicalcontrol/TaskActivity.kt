package com.example.psychologicalcontrol

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class TaskActivity : AppCompatActivity() {
    var helper:Helper = Helper() /*поле*/
    var idUser = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav)
        /*val helper:Helper = Helper()*/
        helper.defineBottomNav(this, this, bottomNavView, R.id.tasks_menu)
        val sharedPreferences = getSharedPreferences("PREFERENCE_USER", Context.MODE_PRIVATE)
        idUser = sharedPreferences.getInt("id_user",0)
        Log.d("!!!!!!!!!!!!", idUser.toString())
    }

    fun showAllTask(view: View){
        println("дратуйти")
    }
    fun clickNewTask(view: View){
        helper.createAlertTask(this)
    }
}