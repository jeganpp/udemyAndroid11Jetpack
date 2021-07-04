package com.example.section8_coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.section8_coroutinesdemo1.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tag = "Jegan"
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            downloadUserDatabutton.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch { downloadUserData() }
            }
            countbutton.setOnClickListener {
                countTextView.text = count++.toString()
            }
        }
    }

    suspend private fun downloadUserData() {
        binding.userDataTextView.text = UserDataManager().getTotalUserCount().toString()
    }
}