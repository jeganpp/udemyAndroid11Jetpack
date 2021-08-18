package com.example.section13_dependencyinjection_demo1

import android.util.Log
import javax.inject.Inject

class SimCard @Inject constructor(private val serviceProvider: ServiceProvider) {

    init {
        Log.i("Jegan", "sim card inserted")
    }

    fun getConnection() {
        serviceProvider.getProvider()
    }
}