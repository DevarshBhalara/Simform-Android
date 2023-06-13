package com.example.demoproject.activityintent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast


class MyReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.e("R", "Timeeeee")
        Toast.makeText(p0, "Times Up!!!!", Toast.LENGTH_LONG).show();
    }
}