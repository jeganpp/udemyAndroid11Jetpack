package com.example.section13_dependencyinjection_demo1

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {
    init {
        Log.i("Jegan", "Service Provider constructed")
    }

    fun getProvider() {
        Log.i("Jegan", "connected to the provider")
    }
}