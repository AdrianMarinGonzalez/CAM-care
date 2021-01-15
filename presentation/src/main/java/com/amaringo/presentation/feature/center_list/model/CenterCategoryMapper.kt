package com.amaringo.presentation.feature.center_list.model

import com.amaringo.domain.model.CenterCategoryDataDTO
import com.amaringo.presentation.R
import com.amaringo.presentation.common.StringLoader

class CenterCategoryMapper(val stringResolver: StringLoader) {

    fun map(model: CenterCategoryDataDTO): CenterCategory {
        return CenterCategory(
            getCategoryTitle(model.category),
            getTitle(model.category),
            getIcon(model.category),
            model.centers.map {
                Center(
                    it.id,
                    it.title,
                    Location(it.location.latitude, it.location.longitude)
                )
            })
    }

    private fun getIcon(category: String): Int {
        return R.drawable.app_icon
    }

    private fun getTitle(category: String): String {
        return stringResolver.load(R.string.app_name)
    }

    private fun getCategoryTitle(category: String): String {
        return stringResolver.load(R.string.app_name)
    }
}