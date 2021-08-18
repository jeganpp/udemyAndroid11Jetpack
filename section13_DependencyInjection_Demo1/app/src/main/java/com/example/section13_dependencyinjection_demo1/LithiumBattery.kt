package com.example.section13_dependencyinjection_demo1

import android.util.Log
import javax.inject.Inject

class LithiumBattery @Inject constructor(): Battery {
    init {
        Log.i("Jegan", "constructing Lithium battery")
    }

    override fun getPower() {
        Log.i("Jegan", "getting power")
    }


}