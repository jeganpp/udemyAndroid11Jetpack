package com.example.section11_notificationdemo1

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.example.section11_notificationdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val channelId = "com.example.section11_notificationdemo1.channel"
    private var notificationManager:NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelId, "demoChannel", "demo description")
        binding.button.setOnClickListener { displayNotification() }
    }

    private fun displayNotification() {
        val notificationId = 45
        val tapResultIntent = Intent(this, SecondActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            tapResultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT)

        val intent2 = Intent(this, MoreDetailActivity::class.java)
        val pendingIntent2 = PendingIntent.getActivity(
            this,
            0,
            intent2,
            PendingIntent.FLAG_UPDATE_CURRENT)

        val detailAction = NotificationCompat.Action.Builder(
            0, "Detail", pendingIntent2).build()


        val intent3 = Intent(this, SettingsActivity::class.java)
        val pendingIntent3 = PendingIntent.getActivity(
            this,
            0,
            intent3,
            PendingIntent.FLAG_UPDATE_CURRENT)

        val settingAction = NotificationCompat.Action.Builder(
            0, "Settings", pendingIntent3).build()

        val notification = NotificationCompat.Builder(this@MainActivity, channelId)
            .setContentTitle("My first Notification")
            .setContentText("Hello Notification world :)")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(false)
            .setContentIntent(pendingIntent)
            .addAction(detailAction)
            .addAction(settingAction)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager?.notify(notificationId, notification)
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }
}