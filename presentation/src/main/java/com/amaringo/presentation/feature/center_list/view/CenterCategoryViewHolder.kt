package com.amaringo.presentation.feature.center_list.view

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amaringo.presentation.R
import com.amaringo.presentation.databinding.CenterCategoryLayoutBinding
import com.amaringo.presentation.feature.center_list.model.Center
import com.amaringo.presentation.feature.center_list.model.CenterCategory

class CenterCategoryViewHolder(private val itemBinding: CenterCategoryLayoutBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(
        centerCategory: CenterCategory,
        onItemSelected: (Center) -> Unit,
        onShowMoreSelected: (CenterCategory) -> Unit
    ) {
        itemBinding.category.text = centerCategory.title
        itemBinding.showMoreButton.setOnClickListener { onShowMoreSelected.invoke(centerCategory) }
        itemBinding.categoryItemsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(
                HorizontalSpaceItemDecoration(
                    context.resources.getDimension(R.dimen.category_list_divider).toInt(),
                    true
                )
            )
            adapter = CenterItemListAdapter(centerCategory.centers.toMutableList(), onItemSelected)
        }
    }
}
