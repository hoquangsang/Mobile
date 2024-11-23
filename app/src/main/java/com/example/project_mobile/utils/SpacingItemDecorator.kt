package com.example.project_mobile.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingItemDecorator(
    private val left: Int = 0,
    private val top: Int = 0,
    private val right: Int = 0,
    private val bottom: Int = 0,
    private val isHorizontal: Boolean = false

) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (isHorizontal) {
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.left = 0
            }
            else {
                outRect.left = left
            }
        } else {
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = 0
                outRect.bottom = bottom
            }
            else if (parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1) {
                outRect.top = top
                outRect.bottom = 0
            }
            else {
                outRect.top = top
                outRect.bottom = bottom
            }
        }
    }
}