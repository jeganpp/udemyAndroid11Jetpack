package com.example.section3_viewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.section3_viewmodelfactory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        binding.apply {
            sum.text = viewModel.getSum().toString()
            addButton.setOnClickListener { addInputToSum() }
        }
    }

    private fun addInputToSum() {
        var num : Int = 0
        binding.apply {
            if (inputEditText != null && inputEditText.text.toString() != "") {
                num = inputEditText.text.toString().toInt()
            }
            viewModel.setSum(num)
            sum.text = viewModel.getSum().toString()
        }
    }
}