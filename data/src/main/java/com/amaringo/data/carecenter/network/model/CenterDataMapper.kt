package com.amaringo.data.carecenter.network.model

import com.amaringo.data.carecenter.network.model.center_categories.GetCentersResponse
import com.amaringo.domain.model.CenterCategoryDataModel
import com.amaringo.domain.model.CenterCategoryModel
import com.amaringo.domain.model.LocationModel

class CenterDataMapper {

    fun map(category: String, apiModel: GetCentersResponse): CenterCategoryDataModel {
        return CenterCategoryDataModel(
            category,
            apiModel.centers.map {
                CenterCategoryModel(
                    it.url,
                    it.title,
                    LocationModel(it.location.latitude, it.location.longitude)
                )
            })
    }
}