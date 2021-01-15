package com.amaringo.presentation.feature.center_list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amaringo.presentation.R
import com.amaringo.presentation.feature.center_list.model.Center
import com.amaringo.presentation.feature.center_list.model.CenterCategory


class CenterCategoryListAdapter(
    private var centers: MutableList<CenterCategory>,
    private val onItemSelected: (Center) -> Unit,
    private val onShowMoreSelected: (CenterCategory) -> Unit
) : RecyclerView.Adapter<CenterCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CenterCategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.center_category_layout,
                parent,
                false
            )
        )

    override fun getItemCount() = centers.size

    override fun onBindViewHolder(holder: CenterCategoryViewHolder, position: Int) {
        holder.bind(centers[position], onItemSelected, onShowMoreSelected)
    }

    fun update(updates: MutableList<CenterCategory>) {
        updates.forEach { updatedItem ->
            if (centers.firstOrNull { it.id == updatedItem.id } == null) {
                centers.add(updatedItem)
                notifyItemInserted(centers.size - 1)
            }
        }
    }
}