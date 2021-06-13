package com.example.section2_bindingdemo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.section2_bindingdemo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            student = getStudentData();
            button.setOnClickListener {
                student = Student(2, "Dharshini", "dharshini@gmail.com")
            }
        }

    }

    private fun getStudentData() : Student {
        return Student(1, "Akshith", "akshith@gmail.com")
    }
}