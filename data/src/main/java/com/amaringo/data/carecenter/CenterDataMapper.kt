package com.amaringo.data.carecenter

import com.amaringo.data.carecenter.model.CenterCategoryDataModel
import com.amaringo.domain.model.*


class CenterDataMapper {

    fun map(category: String, zone: String, model: CenterCategoryDataModel): CenterCategoryDataDTO {
        return CenterCategoryDataDTO(
            category,
            model.centers.map {
                CenterCategoryDTO(
                    it.id,
                    it.title,
                    LocationDTO(it.latitude, it.longitude)
                )
            })
    }
}