package com.amaringo.presentation.feature.center_list.model

import com.amaringo.domain.model.CenterCategoryDataDTO
import com.amaringo.presentation.R
import com.amaringo.presentation.common.StringLoader

class CenterCategoryMapper(val stringResolver: StringLoader) {

    fun map(model: CenterCategoryDataDTO): CenterCategory {
        return CenterCategory(
            model.category,
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

    private fun getTitle(category: String) = when (category) {
            "SENIOR" -> stringResolver.load(R.string.senior_category)
            "CHILDREN_SHELTER" ->  stringResolver.load(R.string.children_shelter_category)
            "SOCIAL_SERVICES" ->  stringResolver.load(R.string.social_services_category)
            "DAY_CARE" ->  stringResolver.load(R.string.day_care_category)
            else -> stringResolver.load(R.string.other_category)
        }
}