package com.example.section4_livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startVal : Int) : ViewModel() {
    var counter = MutableLiveData<Int>()

    init {
        counter.value = startVal
    }

    public fun incrementCounter() {
        counter.value = (counter.value)?.plus(1)
    }
}