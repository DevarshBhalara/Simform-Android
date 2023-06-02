package com.example.demoproject.activityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.demoproject.CheckBoxDemo
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityOne2Binding
import com.example.demoproject.databinding.ActivityOneBinding
import com.example.demoproject.recyclerview.kt.ChatFragment

class ActivityOne : AppCompatActivity() {
    lateinit var binding: ActivityOne2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_one2)
        setContentView(binding.root)
        Log.e("life", "Create")
        supportActionBar!!.hide()
        supportFragmentManager.beginTransaction()
            .replace(R.id.uiComponentsFragment,  CheckBoxDemo())
            .commit()
        setUp()
    }

    private fun setUp() {
        binding.gotoSecond.setOnClickListener {
            val i = Intent(this, ActivityTwo::class.java)
            startActivity(i)
            finish()
        }
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