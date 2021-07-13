package com.example.section12_workmanager_demo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class FilterWorker(context: Context, params:WorkerParameters): Worker(context, params) {

    override fun doWork(): Result {
        try {
            for (i in 0 until 5001) {
                Log.i("Jegan", "Filtering image no: $i")
            }
            return Result.success()
        } catch (e:Exception) {
            return Result.failure()
        }
    }

}