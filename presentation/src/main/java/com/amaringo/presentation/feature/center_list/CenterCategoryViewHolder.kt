package com.amaringo.presentation.feature.center_list

import androidx.recyclerview.widget.RecyclerView
import com.amaringo.presentation.databinding.CenterListItemLayoutBinding
import com.amaringo.presentation.feature.center_list.model.CenterCategory

class CenterCategoryViewHolder(private val itemBinding: CenterListItemLayoutBinding): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(entry: CenterCategory) {
        itemBinding.title.text = entry.title

    }

}
