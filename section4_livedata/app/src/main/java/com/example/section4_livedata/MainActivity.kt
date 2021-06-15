package com.example.section4_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.section4_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModeFactory: MainActivityViewModeFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModeFactory = MainActivityViewModeFactory(5)
        viewModel = ViewModelProvider(this, viewModeFactory).get(MainActivityViewModel::class.java)
        viewModel.counter.observe(this, Observer { binding.textView.text = it.toString() })
        binding.apply {
            button.setOnClickListener { incrementCounter() }
        }
    }

    private fun incrementCounter() {
        viewModel.incrementCounter()
    }
}