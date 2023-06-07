package com.example.demoproject.activityintent.navgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityBottomNavFragmentBinding
import com.example.demoproject.databinding.ActivityBottomNavGraphBinding
import com.example.demoproject.databinding.ActivityNavGraphBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityBottomNavGraph : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavGraphBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = findViewById(R.id.bottomNavBar)
        navView.setupWithNavController(navController)

    }
}