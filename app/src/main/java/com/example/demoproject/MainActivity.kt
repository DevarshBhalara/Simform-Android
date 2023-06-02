package com.example.demoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.demoproject.binding.DataBindingDemo
import com.example.demoproject.binding.ViewBindingDemo
import com.example.demoproject.customview.CalculatorCustomViewGroupDemop
import com.example.demoproject.ktscreen.HomeMarkKTScreenFragment
import com.example.demoproject.ktscreen.LivingRoomScreenFragment
import com.example.demoproject.ktscreen.LivingRoomTempScreen
import com.example.demoproject.layouts.CoordinatorDemoFabButton
import com.example.demoproject.layouts.CorrdinatorLayoutFragment
import com.example.demoproject.recyclerview.*
import com.example.demoproject.recyclerview.kt.ChatFragment
import com.example.demoproject.recyclerview.kt.model.Chat
import com.example.demoproject.screens.CartFragment
import com.example.demoproject.screens.DetailShoes
import com.example.demoproject.screens.HomePageFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        Log.e("Feature 2","Feature 2 is added")
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