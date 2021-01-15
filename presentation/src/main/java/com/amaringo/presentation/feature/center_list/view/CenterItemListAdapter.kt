package com.amaringo.presentation.feature.center_list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amaringo.presentation.R
import com.amaringo.presentation.feature.center_list.model.Center
import com.amaringo.presentation.feature.center_list.model.CenterCategory

class CenterItemListAdapter(
    private var centers: MutableList<Center>,
    private val onItemSelected: ((Center) -> Unit)
) : RecyclerView.Adapter<CenterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CenterViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.center_category_item_layout,
                parent,
                false
            )
        )

    override fun getItemCount() = centers.size

    override fun onBindViewHolder(holder: CenterViewHolder, position: Int) {
        holder.bind(centers[position], onItemSelected)
    }

    fun update(updates: MutableList<Center>) {
        centers = updates
        notifyDataSetChanged()
    }
}
