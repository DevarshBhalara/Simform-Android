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
import com.example.demoproject.recyclerview.MovieSeriesFragment
import com.example.demoproject.recyclerview.SongFragment
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
            .replace(R.id.uiComponentsFragment, SongFragment())
            .commit()
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}