package com.example.psychologicalcontrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.lifecycleScope

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
    fun registration(view: View){
        val nameEdit: EditText = findViewById(R.id.editTextNameReg)
        val surnameEdit: EditText = findViewById(R.id.editTextSurnameReg)
        val emailEdit: EditText = findViewById(R.id.editTextEmailReg)
        val passwordEdit: EditText = findViewById(R.id.editTextPasswordReg)

        val name = nameEdit.text.toString()
        val surname = surnameEdit.text.toString()
        val email = emailEdit.text.toString()
        val password = passwordEdit.text.toString()

        if (name.equals("") || surname.equals("") || email.equals("") || password.equals("")){
            Helper().showToast("Все поля обязательны для заполнения",this)
            return
        }
        val db = DatabaseHelper.getInstance(this,lifecycleScope)

        db!!.insertUser(name, surname, email, password)
        val loginActivity: Intent = Intent(this, MainActivity::class.java)
        startActivity(loginActivity)
        overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
    }
}