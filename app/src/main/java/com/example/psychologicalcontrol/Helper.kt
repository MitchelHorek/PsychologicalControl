package com.example.psychologicalcontrol

import android.content.Context
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class Helper {
    fun defineBottomNav(context: Context, bottomNavView:BottomNavigationView, idItem:Int){

        bottomNavView.selectedItemId = idItem
        bottomNavView.setOnItemSelectedListener { item->
            when(item.itemId) {
                R.id.left_menu -> {
                    println("левое меню")
                    true
                }
                R.id.tasks_menu -> {
                    println("второе меню")
                    true
                }
                R.id.calendar_menu -> {
                    val calendarActivity: Intent = Intent(context, CalendarActivity::class.java)
                    context.startActivity(calendarActivity)
                    true
                }
                R.id.profile -> {

                    true
                }
                else -> {
                    println()
                    false
                }
            }
        }
    }
}