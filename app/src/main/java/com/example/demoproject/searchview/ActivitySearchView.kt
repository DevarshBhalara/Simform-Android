package com.example.demoproject.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivitySearchViewBinding
import com.example.demoproject.recyclerview.adapter.SeriesAdapter
import com.example.demoproject.recyclerview.data.SeriesData
import com.example.demoproject.recyclerview.model.Series
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class ActivitySearchView : AppCompatActivity() {
    private val seriesAdapter = SeriesAdapter()
    var series = mutableListOf<Series>()
    lateinit var binding: ActivitySearchViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
        addData()
        filterData()
    }

    private fun filterData() {
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterDataModel(p0)
                return false
            }
        })
    }

    private fun filterDataModel(text: String?) {
        val filteredList = mutableListOf<Series>()

        for (item in series) {
            if(item.name.lowercase().contains(text.toString().toLowerCase(Locale.ROOT))) {
                filteredList.add(item)
            }
        }

        if(filteredList.isEmpty()) {
            Toast.makeText(this, "No result found", Toast.LENGTH_SHORT).show()
        } else {
            seriesAdapter.filterList(filteredList)
        }
    }

    private fun setUpUI() {
        series = SeriesData.getAllSeries(this)
        seriesAdapter.submitList(series)
        binding.rvExpandable.adapter = seriesAdapter

    }

    private fun addData() {
        binding.addData.setOnClickListener {
            seriesAdapter.addItem(SeriesData.addData(this))
        }
    }
}