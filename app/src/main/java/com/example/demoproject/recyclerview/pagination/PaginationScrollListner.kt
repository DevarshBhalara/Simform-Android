package com.example.demoproject.recyclerview.pagination

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollListner(val layoutManager: LinearLayoutManager): RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItems = layoutManager.findFirstVisibleItemPosition()
        val totalItems = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (!isLoading() && !isLastPage()) {
            if ((visibleItems + firstVisibleItemPosition) >= totalItems && firstVisibleItemPosition >= 0) {
                loadMoreItems()
            }
        }


    }
    companion object {
        var PAGESIZE = 3
    }

    protected abstract fun loadMoreItems()
    abstract fun isLastPage(): Boolean
    abstract fun isLoading(): Boolean
}