package com.example.psychologicalcontrol

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import com.google.android.material.bottomnavigation.BottomNavigationView

class Helper {
    fun defineBottomNav(context: Context, activity: Activity, bottomNavView:BottomNavigationView, idItem:Int){

        bottomNavView.selectedItemId = idItem
        bottomNavView.setOnItemSelectedListener { item->
            when(item.itemId) {
                R.id.left_menu -> {
                    println("левое меню")
                    true
                }
                R.id.tasks_menu -> {
                    val taskActivity: Intent = Intent(context,TaskActivity::class.java)
                    context.startActivity(taskActivity)
                    activity.overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                    true
                }
                R.id.calendar_menu -> {
                    val calendarActivity: Intent = Intent(context, CalendarActivity::class.java)
                    context.startActivity(calendarActivity)
                    /*val activity = context as MainActivity*/
                    activity.overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                    true
                }
                R.id.profile -> {
                    val profileActivity: Intent = Intent(context, ProfileActivity::class.java)
                    context.startActivity(profileActivity)
                    activity.overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                    true
                }
                else -> {
                    println("Пока не придумали")
                    false
                }
            }
        }
    }
    fun createAlertTask(context:Context) {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        builder.setView(inflater.inflate(R.layout.alert_new_task, null))
            .setPositiveButton(R.string.save) { dialog: DialogInterface, which: Int ->
                println("1")
            }.setNegativeButton(R.string.cancel) { dialog: DialogInterface, which: Int ->
                println("2")
            }
        val alert = builder.create()
        alert.show()
    }
}