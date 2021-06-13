package com.example.section3_viewmodeldemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.section3_viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var count : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Jegan", "inside onCreate")
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            //count.text = this.count.toString()
            button.setOnClickListener { incrementCount() }
        }
    }

    private fun incrementCount() {
        this.count ++
        binding.count.text = this.count.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Jegan", "inside onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Jegan", "inside onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Jegan", "inside onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Jegan", "inside onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Jegan", "inside onDestroy")
    }
}