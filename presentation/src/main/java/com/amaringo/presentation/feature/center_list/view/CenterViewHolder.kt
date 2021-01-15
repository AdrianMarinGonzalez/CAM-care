package com.amaringo.presentation.feature.center_list.view

import androidx.recyclerview.widget.RecyclerView
import com.amaringo.presentation.databinding.CenterCategoryItemLayoutBinding
import com.amaringo.presentation.feature.center_list.model.Center

class CenterViewHolder(private val itemBinding: CenterCategoryItemLayoutBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(
        center: Center,
        onItemSelected: (Center) -> Unit
    ) {
        itemBinding.category.text = center.title
        itemBinding.root.setOnClickListener { onItemSelected.invoke(center) }
    }
}
