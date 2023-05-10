package com.example.demoproject.recyclerview.itemdecoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.R

class RecyclerViewItemDecoration(context: Context, resId: Int): RecyclerView.ItemDecoration() {

    private var divider: Drawable = ContextCompat.getDrawable(context, R.drawable.item_divider_recyclerview)!!

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)


        val dividerLeft = 32
        val dividerRight = parent.width - 32

        for (i in 0 until parent.childCount) {
            if( i != parent.childCount - 1) {
                val child = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams

                val dividerTop = child.bottom + params.bottomMargin
                val dividerBottom = dividerTop + divider.intrinsicHeight

                divider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                divider.draw(c)
            }
        }

    }

}