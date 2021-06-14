package com.example.section3_viewmodelfactory

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingNum : Int) : ViewModel() {
    private var sum : Int = 0

    init {
        sum = startingNum
    }

    public fun getSum() : Int {
        return sum
    }

    public fun setSum(num : Int) {
        sum += num
    }
}