package com.example.section3_viewmodeldemo1

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel (){
    private var count : Int = 0

    public fun getCount() : Int {
        return count;
    }

    public fun getUpdatedCount() : Int {
        count ++
        return count
    }
}