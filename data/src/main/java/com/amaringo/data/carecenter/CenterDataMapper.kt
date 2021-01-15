package com.amaringo.data.carecenter

import com.amaringo.domain.model.*


class CenterDataMapper {

    fun map(category: String, model: CenterCategoryDataModel): CenterCategoryDataDTO {
        return CenterCategoryDataDTO(
            category,
            model.centers.map {
                CenterCategoryDTO(
                    it.id,
                    it.title,
                    LocationDTO(it.location.latitude, it.location.longitude)
                )
            })
    }
}