package com.amaringo.presentation.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class VerticalSpaceItemDecoration(
    private val space: Int,
    private val deleteHeaderSpacing: Boolean = true
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
        if (deleteHeaderSpacing && itemPosition == 0) {
            outRect.top = 0
        } else {
            outRect.top = space
        }
    }

}