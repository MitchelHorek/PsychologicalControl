package com.example.psychologicalcontrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.psychologicalcontrol.entities.Category
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            createDatabase();
            /*auth = Firebase.auth*/
        }
        catch (e: java.lang.Exception){
            print(e)
        }

    }

    private fun createDatabase() {
        print("test")
        Log.d("mainactivity", "test")
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "psychological_control"
        ).build()
        Log.d("mainactivity", "test2")
        createBaseCategories()
        /*val category = db.categoryDao().getCategory(1)
        Log.d("mainactivity", String.format("%d", category.id))
        print(category.id)
        if(db.categoryDao().getCategory(1) == null){

        }*/
    }
    private fun createBaseCategories() {
        lifecycleScope.launch {
            val category = db.categoryDao().getCategory(1)
            if (category == null){
                insertNewCategory("лекрства")
            }
            val category2 = db.categoryDao().getCategory(2)
            if (category2 == null){
                insertNewCategory("обследование")
            }
            /*insertUserToCategory(1, 1)
            insertUserToCategory(1, 2)*/



        }
    }
    public fun insertNewCategory(name: String){
        lifecycleScope.launch {
            val category = Category(0, name)
            db.categoryDao().insertCategory(category)
        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        /*val currentUser = auth.currentUser
        if(currentUser != null){
            reload()
        }*/
    }

    private fun reload() {
        val taskActivity: Intent = Intent(this,TaskActivity::class.java)
        this.startActivity(taskActivity)
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
    }

    fun login(view: View){
        //to do оработать авторизацию
        val editTextEmailLogin:EditText = findViewById(R.id.editTextEmailLogin)
        val editTextPasswordLogin:EditText = findViewById(R.id.editTextPasswordLogin)

        auth.signInWithEmailAndPassword(editTextEmailLogin.text.toString(), editTextPasswordLogin.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = auth.currentUser
                    /*updateUI(user)*/
                } else {
                    /*updateUI(null)*/
                }
            }

    }
}
//todo добавить плавный переход активити календарь +++
//todo навесить листенер на календарь
//todo кнопка плюсика навесить листенер x2(каледарь) и вектор трех точек
//todo доработать обработку меню переходы +++
//todo посмотреть формат даты в алерте
//todo доделать имоджи