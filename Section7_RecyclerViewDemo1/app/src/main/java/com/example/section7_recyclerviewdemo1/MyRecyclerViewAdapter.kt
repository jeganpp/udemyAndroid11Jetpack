package com.example.section7_recyclerviewdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val fruitsList: List<Fruit>, private val clickListener:(Fruit)->Unit): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator: LayoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflator.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitsList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }
}


class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit, clickListener:(Fruit)->Unit) {
        var textView: TextView = view.findViewById<TextView>(R.id.nametextView)
        textView.text = fruit.name
        view.setOnClickListener {
            clickListener(fruit)
        }
    }
}