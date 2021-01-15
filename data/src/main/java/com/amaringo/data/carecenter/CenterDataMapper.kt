package com.amaringo.data.carecenter

import com.amaringo.data.carecenter.model.CenterCategoryDataModel
import com.amaringo.domain.model.*


class CenterDataMapper {

    fun map(category: String, zone: String, model: CenterCategoryDataModel): CategoryDataDTO {
        return CategoryDataDTO(
            category,
            model.centers.map {
                CategoryCenterDTO(
                    it.id,
                    it.title,
                    LocationDTO(it.latitude, it.longitude)
                )
            })
    }
}