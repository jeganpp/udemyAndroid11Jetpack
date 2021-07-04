package com.example.section8_coroutinesdemo1

import kotlinx.coroutines.*

class UserDataManager {
    var count = 0
    lateinit var deffered: Deferred<Int>

    suspend fun getTotalUserCount(): Int {
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(3000)
                count = 7
            }
            deffered = async(Dispatchers.IO) {
                delay(5000)
                return@async 8
            }

        }
        return count + deffered.await()
    }
}