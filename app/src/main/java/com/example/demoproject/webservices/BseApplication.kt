package com.example.demoproject.webservices

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.databinding.BaseObservable
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BseApplication: Application() {
    @SuppressLint("StaticFieldLeak")
    companion object {
        private var context: Context? = null

        fun getAppContext(): Context? {
            return context
        }
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }


}