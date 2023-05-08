package com.example.psychologicalcontrol

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

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

    fun showToast(text: String, context: Context){
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
    fun sha256(input: String): String{
        val md = MessageDigest.getInstance("SHA-256")
        val input2 = input.toByteArray()
        val bytes = md.digest(input2)
        return Base64.getEncoder().encodeToString(bytes)
    }
}