package com.example.section3_viewmodel_challenge1

import androidx.lifecycle.ViewModel

class SumViewModel : ViewModel () {
    private var sum : Int = 0

    public fun getSum() : String {
        return sum.toString()
    }

    public fun getUpdatedSum(num : String) : String {
        if (!num.equals("")) {
            sum += num.toInt()
        }
        return sum.toString()
    }
}