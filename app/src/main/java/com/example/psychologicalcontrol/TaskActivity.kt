package com.example.psychologicalcontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class TaskActivity : AppCompatActivity() {
    var helper:Helper = Helper() /*поле*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav)
        /*val helper:Helper = Helper()*/
        helper.defineBottomNav(this, this, bottomNavView, R.id.tasks_menu)

    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.left_menu -> {
                println("левое меню")
                true
            }
            R.id.tasks_menu -> {
                println("второе меню")
                true
            }
            R.id.calendar_menu -> {
                true
            }
            R.id.profile -> {

                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }*/
    fun showAllTask(view: View){
        println("дратуйти")
    }
    fun clickNewTask(view: View){
        helper.createAlertTask(this)
    }
}