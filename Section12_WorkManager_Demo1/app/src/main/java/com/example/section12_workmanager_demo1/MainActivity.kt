package com.example.section12_workmanager_demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.section12_workmanager_demo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        val LOOP_COUNT = "loop_count"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener { setOneTimeWorkRequest() }
    }

    private fun setOneTimeWorkRequest() {
        val data = Data.Builder()
            .putInt(LOOP_COUNT, 5001)
            .build()
        val workManager = WorkManager.getInstance(applicationContext)
        val constraints: Constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val filterRequest = OneTimeWorkRequest.Builder(FilterWorker::class.java).build()
        val downloadRequest = OneTimeWorkRequest.Builder(DownloadWorker::class.java).build()
        val compressRequest = OneTimeWorkRequest.Builder(CompressWorker::class.java).build()
        val uploadRequest = OneTimeWorkRequest
            .Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        val parallelWorks = mutableListOf<OneTimeWorkRequest>()
        parallelWorks.add(filterRequest)
        parallelWorks.add(downloadRequest)

        workManager.beginWith(parallelWorks).then(compressRequest).then(uploadRequest).enqueue()
        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this, Observer {
                binding.textView.text = it.state.name
                if(it.state.isFinished) {
                    val outputData = it.outputData
                    val message:String? = outputData.getString(UploadWorker.OUTPUT_TIME)
                    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}