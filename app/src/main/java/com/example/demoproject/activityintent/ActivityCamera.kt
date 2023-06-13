package com.example.demoproject.activityintent

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.demoproject.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class ActivityCamera : AppCompatActivity() {
    private var uri: Uri? = null
    lateinit var button: Button

    companion object {
        private const val CAMERA_PERMISSION_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        button = findViewById(R.id.btnCamera)

        button.setOnClickListener {
            checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
        }
    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            invokeCamera()
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                invokeCamera()
                Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun invokeCamera() {
        val file = createImageFile()

        try{
            uri = FileProvider.getUriForFile(this, "${applicationContext.packageName}.provider", file)
            Log.d("uri", uri.toString())
        } catch (e: Exception) {
            Log.e("Error", "Error : ${e.message}")
        }
        getCameraImage.launch(uri)

    }

    private val getCameraImage = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        success ->
        if(success) {
            Toast.makeText(this, "Image save in Downloads folder", Toast.LENGTH_SHORT).show()
            Log.d("Image", "Location $uri")
        } else {
            Toast.makeText(this, "Image not save in Downloads folder", Toast.LENGTH_SHORT).show()
            Log.d("Image", "Image not saved $uri")
        }
    }

    private fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
//        val imageDirectory = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
//        return File.createTempFile(
//            "my_${timeStamp}",
//            ".jpg",
//            imageDirectory
//        ).apply {
//            currentPath = absolutePath
//        }
        Log.d("Dir", Environment.getExternalStorageDirectory().listFiles()!![8].toString())
        return File(Environment.getExternalStorageDirectory().listFiles()!![8], "my_${timeStamp}.png")
    }

}