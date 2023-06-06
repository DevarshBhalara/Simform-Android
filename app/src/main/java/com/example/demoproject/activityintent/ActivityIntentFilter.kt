package com.example.demoproject.activityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityIntentFilterBinding

class ActivityIntentFilter : AppCompatActivity() {
    lateinit var binding: ActivityIntentFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intent_filter)
        setContentView(binding.root)
        setUpBtnClick()
        val message = intent.getStringExtra(Intent.EXTRA_TEXT)
        if(message != null) {
            binding.tvMsg.text = message
        }
        Log.d("FromAnotherApp", message ?: "")
    }

    private fun setUpBtnClick() {
        binding.btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "devarshbhalara3072@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Good Morning")
            intent.putExtra(Intent.EXTRA_TEXT, "How are you")
            startActivity(intent)
        }
    }
}