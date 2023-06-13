package com.example.demoproject.activityintent

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.database.DatabaseUtils
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityImplicitIntentBinding

class ActivityImplicitIntent : AppCompatActivity() {

    lateinit var binding: ActivityImplicitIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_implicit_intent)
        setContentView(binding.root)
        makeCall()
        sendMessage()
        openYoutube()
    }

    private fun openYoutube() {

        binding.btnYT.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }

    }

    @SuppressLint("IntentReset")
    private fun sendMessage() {
        binding.btnMsg.setOnClickListener {
            val message = binding.tfMsg.text
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+9737043536))
            intent.putExtra("sms_body", message.toString())
            startActivity(intent)
        }
    }

    private fun makeCall() {
        binding.btnCall.setOnClickListener {
            val number = binding.tfPhone.text
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(intent)
        }
    }
}