package com.example.section3_viewmodeldemo1

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.section3_viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var vm : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Jegan", "inside onCreate")
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.apply {
            count.text = vm.getCount().toString()
            button.setOnClickListener { incrementCount() }
        }
    }

    private fun incrementCount() {
        binding.count.text = vm.getUpdatedCount().toString()
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