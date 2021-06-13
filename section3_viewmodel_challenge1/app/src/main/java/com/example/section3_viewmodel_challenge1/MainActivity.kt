package com.example.section3_viewmodel_challenge1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.section3_viewmodel_challenge1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var vm : SumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProvider(this).get(SumViewModel::class.java)
        binding.apply {
            sum.text = vm.getSum()
            add.setOnClickListener { addInput() }
        }
    }

    private fun addInput() {
        binding.apply {
            sum.text = vm.getUpdatedSum(input.text.toString())
        }
    }
}