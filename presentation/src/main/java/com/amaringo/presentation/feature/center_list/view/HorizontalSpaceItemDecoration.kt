package com.amaringo.presentation.feature.center_list.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class HorizontalSpaceItemDecoration(
    private val space: Int,
    private val deleteHeaderSpacing: Boolean = false
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition: Int = parent.getChildAdapterPosition(view)
        if (deleteHeaderSpacing && itemPosition == 0) {
            outRect.left = 0
        } else {
            outRect.left = space
        }
    }
}