package com.example.demoproject.combinescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.demoproject.R

class CombineScreenActivity : AppCompatActivity() {
    lateinit var rvComponent: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combine_screen)

        rvComponent = findViewById(R.id.rvComponents)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val adapter = CombineScreenAdapter(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvComponent.layoutManager = layoutManager
        rvComponent.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        adapter.submitData(CombineScreenModel.getAllComponents())
        rvComponent.adapter = adapter
    }
}