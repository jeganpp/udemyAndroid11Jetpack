package com.example.section8_coroutinedemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Main).launch {
            Log.i("Jegan", "starting computation...")

            val stk1 = async(IO) {getStock1()}
            val stk2 = async(IO) {getStock2()}
            val total = stk1.await() + stk2.await()
            Log.i("Jegan", "total val is: $total")
            //Toast.makeText(applicationContext, total, Toast.LENGTH_LONG).show()
        }
    }

    suspend private fun getStock1(): Int {
        Log.i("Jegan", "getting getStock1")
        delay(3000)
        return 250
    }

    suspend private fun getStock2(): Int {
        Log.i("Jegan", "getting getStock2")
        delay(6000)
        return 150
    }
}