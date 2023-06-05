package com.example.demoproject.recyclerview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demoproject.ButtonDemo
import com.example.demoproject.FloatingActionDemo
import com.example.demoproject.SnackBarDemo
import com.example.demoproject.TextInputLayoutDemo

class BottomNavAdapter(fa: FragmentActivity, private val totalCount: Int): FragmentStateAdapter(fa) {

    val listOfFragment = listOf(FloatingActionDemo(), SnackBarDemo())

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SongFragment()
            1 -> MovieSeriesFragment()
            2 -> ExpandableRecyclerView()
            else -> SongFragment()
        }
    }
}