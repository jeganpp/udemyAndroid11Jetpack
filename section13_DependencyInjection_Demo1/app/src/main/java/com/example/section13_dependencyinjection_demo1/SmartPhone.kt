package com.example.section13_dependencyinjection_demo1

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(battery: Battery, simCard: SimCard, sdcard: Sdcard) {

    init {
        battery.getPower()
        simCard.getConnection()
        sdcard.getSpaceAvailable()
        Log.i("Jegan", "smart phone assembled")
    }

    fun makeCall() {
        Log.i("Jegan", "making call ....")
    }
}