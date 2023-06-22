package com.example.demoproject.activityintent

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityTwoBinding

class ActivityTwo : AppCompatActivity() {
    lateinit var binding: ActivityTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two)
        setContentView(binding.root)

        getData()
        passDataToPrevious()
    }

    private fun passDataToPrevious() {

        binding.btnPassback.setOnClickListener {
            val intent = Intent()
            val value = binding.edData.text
            intent.putExtra("datafromsecond", value.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getData() {
        val i = intent
        binding.tvWelcome.text = "Welcome ${i.getStringExtra("name").toString()}"

        if (i != null) {
            Log.e("name", i.getStringExtra("name").toString())
            Toast.makeText(this, i.getStringExtra("name").toString(), Toast.LENGTH_SHORT).show()
        }


    }
}