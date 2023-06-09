package com.example.demoproject.combinescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoproject.R
import com.example.demoproject.recyclerview.kt.ChatFragment

class HostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

        val component = CombineScreenModel.getAllComponents()

        val postion = intent.getIntExtra("position",0)

        val a = component[postion].fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.uiComponentsFragment,  component[postion].fragment!!)
            .commit()
    }
}