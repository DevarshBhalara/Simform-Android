package com.example.demoproject.activityintent.appdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityNavAppDrawerBinding

class ActivityNavAppDrawer : AppCompatActivity() {
    lateinit var binding: ActivityNavAppDrawerBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavAppDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.fragment1, R.id.fragment2, R.id.fragment3,
        ).setOpenableLayout(binding.drawerLayout).build()

        navController = (supportFragmentManager.fragments[0] as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navigationView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
            return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }
}