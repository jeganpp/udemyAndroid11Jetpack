package com.example.section7_recyclerviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.section7_recyclerviewdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fruitsList = listOf(Fruit("mango", "Manny"), Fruit("orange", "Ogay"),
            Fruit("papaya", "Peter"), Fruit("guava", "Guna"), Fruit("jack fruit", "Jacky"),
            Fruit("lichi", "Lauren"), Fruit("banana", "Bhaskar"))
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            myRecyclerView.setBackgroundColor(Color.YELLOW)
            myRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            myRecyclerView.adapter = MyRecyclerViewAdapter(fruitsList, {selectedFruit:Fruit -> listItemClicked(selectedFruit)})
        }
    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(this, "Supplier name is: ${fruit.supplier}", Toast.LENGTH_LONG).show()
    }
}