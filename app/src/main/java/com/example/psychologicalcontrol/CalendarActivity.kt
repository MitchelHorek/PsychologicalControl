package com.example.psychologicalcontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Date

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_calendar)
        val helper:Helper = Helper()
        helper.defineBottomNav(this,bottomNavView,R.id.calendar_menu)
        val calendar: CalendarView = findViewById(R.id.calendarView)
        calendar.date = Date().time
    }
}