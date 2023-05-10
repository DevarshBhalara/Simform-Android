package com.example.demoproject.TabLayout

import android.content.Context
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demoproject.ButtonDemo
import com.example.demoproject.FloatingActionDemo
import com.example.demoproject.SnackBarDemo
import com.example.demoproject.TextInputLayoutDemo
import com.google.android.material.textfield.TextInputLayout

class Adapter(fa: FragmentActivity, private val totalCount: Int): FragmentStateAdapter(fa) {

    val listOfFragment = listOf(FloatingActionDemo(), SnackBarDemo())

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ButtonDemo()
            1 -> SnackBarDemo()
            2 -> TextInputLayoutDemo()
            else -> ButtonDemo()
        }
    }
}