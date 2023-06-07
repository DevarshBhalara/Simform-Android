package com.example.demoproject.activityintent.navgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityNavGraphBinding

class ActivityNavGraph : AppCompatActivity() {
    lateinit var binding: ActivityNavGraphBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavGraphBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setupWithNavController((supportFragmentManager.fragments[0] as androidx.navigation.fragment.NavHostFragment).navController)

    }
}