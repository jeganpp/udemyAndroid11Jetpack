package com.example.section5_2waybindingdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var name = MutableLiveData<String>()

    init {
        name.value = "Akshith"
    }
}