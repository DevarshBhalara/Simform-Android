package com.example.demoproject.activityintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.demoproject.CheckBoxDemo
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityOne2Binding
import com.example.demoproject.databinding.ActivityOneBinding
import com.example.demoproject.recyclerview.kt.ChatFragment

class ActivityOne : AppCompatActivity() {
    lateinit var binding: ActivityOne2Binding
    private val getData = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            if(intent != null) {
                addData(intent)
            }
        }
    }

    private fun addData(intent: Intent) {
        binding.tvFromSecond.text = intent.getStringExtra("datafromsecond")
        Toast.makeText(this, intent.getStringExtra("datafromsecond").toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOne2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("life", "Create")
        setUp()
    }

    private fun setUp() {
        binding.gotoSecond.setOnClickListener {
            val value = binding.edName.text
            val i = Intent(this, ActivityTwo::class.java)
            i.putExtra("name", value.toString())
            getData.launch(i)
//            i.putExtra("name", value.toString())
//            startActivity(i)
        }

        binding.btnImplicitIntent.setOnClickListener {
            val intent = Intent(this, ActivityImplicitIntent::class.java)
            startActivity(intent)
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