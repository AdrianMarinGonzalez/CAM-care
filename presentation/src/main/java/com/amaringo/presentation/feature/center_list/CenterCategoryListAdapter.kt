package com.amaringo.presentation.feature.center_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amaringo.presentation.R
import com.amaringo.presentation.feature.center_list.model.CenterCategory


class CenterCategoryListAdapter(private var centers: MutableList<CenterCategory>): RecyclerView.Adapter<CenterCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CenterCategoryViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.center_list_item_layout, parent, false)
    )

    override fun getItemCount() = centers.size

    override fun onBindViewHolder(holder: CenterCategoryViewHolder, position: Int) {
        holder.bind(centers[position])
    }

    fun update(updates: MutableList<CenterCategory>) {
        centers = updates
        notifyDataSetChanged()
    }
}