package com.amaringo.data.carecenter.model

import com.amaringo.domain.model.*


class CategoryDataMapper {

    fun map(category: String, zone: String, model: CategoryDataModel): CategoryDataDTO {
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