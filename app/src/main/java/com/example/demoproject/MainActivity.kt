package com.example.demoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.example.demoproject.recyclerview.kt.ChatFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        Log.e("Feature 2","Feature 2 is added")
        val uri = intent.data
        supportActionBar!!.hide()
        supportFragmentManager.beginTransaction()
            .replace(R.id.uiComponentsFragment,  ChatFragment())
            .commit()
    }
    override fun onStart() {
        super.onStart()
        Log.e("life", "Starr")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Life", "Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Life", "Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Life", "Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Life", "Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Life", "Destroy")
    }

}