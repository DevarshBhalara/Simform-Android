package com.example.demoproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


@SuppressLint("CustomSplashScreen")
class ActivitySplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        val image = findViewById<ImageView>(R.id.imageView)
        image.animation = AnimationUtils.loadAnimation(this, R.anim.image_animation)
        image.animation.start()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 4000)
    }
}