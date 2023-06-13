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
        setContentView(R.layout.activity_main)

        Log.e("Feature 2","Feature 2 is added")
        val uri = intent.data
        supportActionBar!!.hide()
        supportFragmentManager.beginTransaction()
            .replace(R.id.uiComponentsFragment,  ChatFragment())
            .commit()
    }
}