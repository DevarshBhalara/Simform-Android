package com.example.demoproject.activityintent

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.demoproject.R
import kotlin.concurrent.timer

class ActivityPendingIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_intent)
         val btn = findViewById<Button>(R.id.click)
        btn.setOnClickListener {
            startAlert(it)
        }
    }


    private fun startAlert(v: View) {
        val intent = Intent(this, MyReceiver::class.java)
        val pIntent = PendingIntent.getBroadcast(applicationContext, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1 * 10000), pIntent)
    }
}