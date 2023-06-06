package com.example.demoproject.activityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.example.demoproject.R
import java.io.File

class ActivityCamera : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        button = findViewById(R.id.btnCamera)

        button.setOnClickListener {
            openCamera(it)
        }
    }

    val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->

        if(result.resultCode == RESULT_OK) {
            Log.d("image", result.data?.data.toString())

        } else {
            Log.d("image", "fail")
        }
    }

    private fun openCamera(view: View) {
        val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "App")
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(intent)
    }
}