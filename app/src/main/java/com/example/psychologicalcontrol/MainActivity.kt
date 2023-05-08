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
    private var db:DatabaseHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            db = DatabaseHelper.getInstance(this, lifecycleScope)
            /*auth = Firebase.auth*/
        }
        catch (e: java.lang.Exception){
            print(e)
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

        /*auth.signInWithEmailAndPassword(editTextEmailLogin.text.toString(), editTextPasswordLogin.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = auth.currentUser
                    *//*updateUI(user)*//*
                } else {
                    *//*updateUI(null)*//*
                }
            }*/
        val email = editTextEmailLogin.text.toString()
        val password = editTextPasswordLogin.text.toString()
        if (email.equals("") || password.equals("")){
            Helper().showToast("Все поля должна быть заполнены", this)
            return
        }
        val helper = Helper()
        val passwordSHA = helper.sha256(password)
        val db = DatabaseHelper.getInstance(this,lifecycleScope)
        if (db?.checkUser(email, passwordSHA) == true){
            val taskActivity: Intent = Intent(this,TaskActivity::class.java)
            this.startActivity(taskActivity)
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
        }
        else {
            helper.showToast("Неверные данные", this)
        }

    }
    fun goToRegistration(view: View){
        val registrationActivity: Intent = Intent(this,RegistrationActivity::class.java)
        startActivity(registrationActivity)
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
    }
}
//todo добавить плавный переход активити календарь +++
//todo навесить листенер на календарь
//todo кнопка плюсика навесить листенер x2(каледарь) и вектор трех точек
//todo доработать обработку меню переходы +++
//todo посмотреть формат даты в алерте
//todo доделать имоджи