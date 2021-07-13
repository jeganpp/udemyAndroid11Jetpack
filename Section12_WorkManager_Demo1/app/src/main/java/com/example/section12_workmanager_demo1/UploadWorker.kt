package com.example.section12_workmanager_demo1

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, params:WorkerParameters): Worker(context, params) {

    companion object {
        const val OUTPUT_TIME = "output_time"
    }

    override fun doWork(): Result {
        try {
            val time = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
            val currentDate = time.format(Date())
            val outputData = Data.Builder()
                .putString(OUTPUT_TIME, currentDate)
                .build()
            val count = inputData.getInt(MainActivity.LOOP_COUNT, 0)
            for (i in 0 until count) {
                Log.i("Jegan", "uploading image no: $i")
            }
            return Result.success(outputData)
        } catch (e:Exception) {
            return Result.failure()
        }
    }

}