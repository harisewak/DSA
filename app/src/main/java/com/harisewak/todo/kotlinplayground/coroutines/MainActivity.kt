package com.harisewak.todo.kotlinplayground.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.harisewak.todo.R
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await

data class Person(
        val name: String = "",
        val age: Int = -1
)

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvDummy = findViewById<TextView>(R.id.tvDummy)
        val document = Firebase.firestore.collection("coroutines").document("people")
        val anotherPerson = Person("Karthik", 30)
        lifecycleScope.launch(Dispatchers.IO) {
            document.set(anotherPerson).await()
            val person = document.get().await().toObject(Person::class.java)
            withContext(Dispatchers.Main) {
                tvDummy.text = person.toString()
            }
        }
    }

    suspend fun networkCall1(): String {
        delay(3000)
        return "networkCall1"
    }
    suspend fun networkCall2(): String {
        delay(3000)
        return "networkCall2"
    }

//    fun demoCode() {
//        repeat(5) { Log.d(TAG, "repeating i = $it")}
//    }

//    fun fib(i: Int) {
//        if (i == 0) return 1
//        if (i == 1) return 2
//        else return fib(i) + fib(i+1)
//    }

}