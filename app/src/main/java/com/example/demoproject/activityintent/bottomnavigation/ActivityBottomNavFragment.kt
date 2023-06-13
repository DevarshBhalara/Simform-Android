package com.example.demoproject.activityintent.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityBottomNavFragmentBinding
import com.example.demoproject.recyclerview.kt.ChatFragment
import com.example.demoproject.screens.DetailShoes

class ActivityBottomNavFragment : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_nav_fragment)
        binding = ActivityBottomNavFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments, DetailShoes())
            .commit()

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> supportFragmentManager.beginTransaction().replace(R.id.fragments, DetailShoes()).commit()
                R.id.search -> supportFragmentManager.beginTransaction().replace(R.id.fragments, SearchFragment()).commit()
                R.id.add -> supportFragmentManager.beginTransaction().replace(R.id.fragments, AddFragment()).commit()
            }
            return@setOnItemSelectedListener true
        }
    }


}