package com.example.demoproject.searchview

import android.app.SearchManager
import android.database.MatrixCursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivitySearchViewBinding
import com.example.demoproject.recyclerview.adapter.SeriesAdapter
import com.example.demoproject.recyclerview.data.SeriesData
import com.example.demoproject.recyclerview.model.Series
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
        setupSearchView()
    }

    private fun setupSearchView() {
        val from = arrayOf(SearchManager.SUGGEST_COLUMN_TEXT_1)
        val to = intArrayOf(R.id.searchItemID)
        val cursorAdapter = SimpleCursorAdapter(
            this,
            R.layout.item_search_suggestion,
            null,
            from,
            to,
            SimpleCursorAdapter.NO_SELECTION
        )

        binding.searchView.apply {
            suggestionsAdapter = cursorAdapter

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    val suggestions = seriesAdapter.series.map {
                        it.name
                    }
                    val suggestionSet = suggestions.toSet()

                    Log.d("sugg", suggestionSet.toString())
                    val cursor =
                        MatrixCursor(arrayOf(BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1))
                    newText?.let { text ->
                        suggestionSet.forEachIndexed { index, suggestion ->
                            if (suggestion.contains(query, true))
                                cursor.addRow(arrayOf(index, suggestion))
                        }
                    }
                    suggestionsAdapter.changeCursor(cursor)
                    filterDataModel(newText)
                    return true
                }
            })

            setOnSuggestionListener(object : SearchView.OnSuggestionListener {
                override fun onSuggestionSelect(position: Int): Boolean {
                    return false
                }

                override fun onSuggestionClick(position: Int): Boolean {
                    val query = suggestionsAdapter.cursor.getString(1)
                    setQuery(query, false)
                    return true
                }
            })
        }
    }


    private fun filterDataModel(text: String?) {
        val filteredList = mutableListOf<Series>()
        var name = ""
        for (item in series) {
            if(item.name.lowercase().contains(text.toString().lowercase(Locale.ROOT)) && name != item.name) {
                name = item.name
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