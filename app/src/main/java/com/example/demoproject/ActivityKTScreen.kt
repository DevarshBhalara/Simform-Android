package com.example.demoproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.demoproject.databinding.ActivityKtscreenBinding
import com.example.demoproject.ktscreen.HomeMarkKTScreenFragment
import com.example.demoproject.ktscreen.LivingRoomScreenFragment
import com.example.demoproject.ktscreen.LivingRoomTempScreen
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class ActivityKTScreen : AppCompatActivity() {
    lateinit var binding: ActivityKtscreenBinding

    lateinit var bottomNavView: BottomNavigationMenuView
    lateinit var view: View
    lateinit var customViewOne: View
    lateinit var customViewTwo: View
    lateinit var customViewThree: View
    lateinit var itemView: BottomNavigationItemView
    lateinit var customNavLayout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = DataBindingUtil.setContentView(this,R.layout.activity_ktscreen);


        Log.e("Feature 2","Feature 2 is added")
        supportActionBar!!.hide()

        setUpBottomNav()


        setCurrentFragment(LivingRoomScreenFragment(), R.id.livingRoom)

        binding.bottomView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.livingRoom -> setCurrentFragment(LivingRoomScreenFragment(), it.itemId)
                R.id.homeMart -> setCurrentFragment(HomeMarkKTScreenFragment(), it.itemId)
                R.id.tempScreen -> setCurrentFragment(LivingRoomTempScreen(), it.itemId)
            }
            return@setOnItemSelectedListener true
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setUpBottomNav() {
        bottomNavView = binding.bottomView.getChildAt(0) as BottomNavigationMenuView

        view = bottomNavView.getChildAt(0)
        itemView = view as BottomNavigationItemView
        customViewOne = LayoutInflater.from(this).inflate(R.layout.item_bottom_navigation, bottomNavView, false)
        val btn = customViewOne.findViewById<ExtendedFloatingActionButton>(R.id.add_fab)
        btn.shrink()
        btn.text = "Living"
        itemView.addView(customViewOne)

        view = bottomNavView.getChildAt(1)
        itemView = view as BottomNavigationItemView
        customViewTwo = LayoutInflater.from(this).inflate(R.layout.item_bottom_navigation, bottomNavView, false)
        val btn2 = customViewTwo.findViewById<ExtendedFloatingActionButton>(R.id.add_fab)
        btn2.shrink()
        btn2.text = "Home"
        itemView.addView(customViewTwo)

        view = bottomNavView.getChildAt(2)
        itemView = view as BottomNavigationItemView
        customViewThree = LayoutInflater.from(this).inflate(R.layout.item_bottom_navigation, bottomNavView, false)
        val btn3 = customViewThree.findViewById<ExtendedFloatingActionButton>(R.id.add_fab)
        btn3.shrink()
        btn3.text = "Temperature"
        itemView.addView(customViewThree)
    }

    private fun setCurrentFragment(fragment: Fragment, id: Int) {
        val btn = customViewOne.findViewById<ExtendedFloatingActionButton>(R.id.add_fab)
        val btn2 = customViewTwo.findViewById<ExtendedFloatingActionButton>(R.id.add_fab)
        val btn3 = customViewThree.findViewById<ExtendedFloatingActionButton>(R.id.add_fab)

        if (id == R.id.livingRoom) {
            btn.extend()
            btn2.shrink()
            btn3.shrink()
        }
        if (id == R.id.homeMart) {
            btn.shrink()
            btn2.extend()
            btn3.shrink()
        }
        if (id == R.id.tempScreen) {
            btn.shrink()
            btn2.shrink()
            btn3.extend()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.uiComponentsFragment, fragment)
            .commit()
    }
}