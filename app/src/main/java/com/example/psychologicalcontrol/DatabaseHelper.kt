package com.example.psychologicalcontrol

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.psychologicalcontrol.entities.Category
import com.example.psychologicalcontrol.entities.CategoryUser
import com.example.psychologicalcontrol.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DatabaseHelper private constructor(context: Context, lifecycleScope: LifecycleCoroutineScope){
    private lateinit var db: AppDatabase
    private lateinit var applicationContext: Context
    private lateinit var lifecycleScope: LifecycleCoroutineScope

    init {
        this.applicationContext = context
        this.lifecycleScope = lifecycleScope
    }

    companion object {

        @Volatile
        private var instance: DatabaseHelper? = null

        fun getInstance(context: Context, lifecycleScope: LifecycleCoroutineScope): DatabaseHelper? {
            if (instance != null) {
                instance!!.applicationContext  = context
                instance!!.lifecycleScope  = lifecycleScope
            }
            else {
                synchronized(this) {
                    instance?: DatabaseHelper(context, lifecycleScope).also { instance = it }
                    instance?.createDatabase()
                }
            }
            return instance;
        }
    }

    private fun createDatabase() {
        print("test")
        Log.d("mainactivity", "test")
        instance!!.db = Room.databaseBuilder(
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

    private fun createBaseCategories() {//вызов необходимого метода в праивльном потоке(типо мы указываем САМИ)
        lifecycleScope.launch {
            val category = instance!!.db.categoryDao().getCategory(1)
            if (category == null){
                insertNewCategory("лекрства")
            }
            val category2 = instance!!.db.categoryDao().getCategory(2)
            if (category2 == null){
                insertNewCategory("обследование")
            }
            /*insertUserToCategory(1, 1)
            insertUserToCategory(1, 2)*/



        }
    }

    fun insertNewCategory(name: String){
        lifecycleScope.launch {
            val category = Category(0, name)
            instance!!.db.categoryDao().insertCategory(category)
        }

    }

    fun insertUser(name: String, surname:String, email:String, password: String){
        val user = User(0, name, surname, email, Helper().sha256(password))
        lifecycleScope.launch{
            instance!!.db.userDao().insertUser(user)
        }

    }

    fun checkUser(login: String, password: String): Int{

        var idUser: Int = 0
        val userDao = instance!!.db.userDao()
        try {
            idUser = runBlocking(Dispatchers.IO){
                userDao.getUserByLoginPassword(login, password)
            }
        }
        catch(e:Exception){
            idUser = 0
        }
        if(idUser != 0){
            insertCategoryUser(idUser,1)
            insertCategoryUser(idUser,2)
        }
        return idUser
    }
    fun insertCategoryUser(idUser:Int, idCategory:Int){
        val categoryUserDao = instance!!.db.categoryUserDao()
        val categories: List<Int>  = runBlocking(Dispatchers.IO){
            categoryUserDao.getCategoriesByUser(idUser)
        }
        if(!categories.contains(1)){
            runBlocking(Dispatchers.IO){
                categoryUserDao.insertCategoryUser(CategoryUser(idUser,1))
            }
        }

    }
    fun selectCategoriesByUser(idUser:Int): List<Category>{
        val categoryUserDao = instance!!.db.categoryUserDao()
        val categoryDao = instance!!.db.categoryDao()
        var categoryList = ArrayList<Category>()
        val categories: List<Int> = runBlocking(Dispatchers.IO){
            categoryUserDao.getCategoriesByUser(idUser)
        }
        for(category in categories){
            val currentCategory = runBlocking(Dispatchers.IO){
                categoryDao.getCategory(category)
            }
            if (currentCategory != null) {
                categoryList.add(currentCategory)
            }
        }
        return  categoryList
    }
}