package com.example.section13_dependencyinjection_demo1

import android.util.Log

class Sdcard {
    init {
        Log.i("Jegan", "sdcard is inserted")
    }

    fun getSpaceAvailable() {
        Log.i("Jegan", "space available is ...")
    }
}