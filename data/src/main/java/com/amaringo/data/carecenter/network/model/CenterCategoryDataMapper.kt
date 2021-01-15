package com.amaringo.data.carecenter.network.model

import com.amaringo.data.carecenter.network.model.center_categories.GetCentersResponse
import com.amaringo.data.carecenter.model.CenterCategoryDataModel
import com.amaringo.data.carecenter.model.CenterCategoryModel

class CenterCategoryDataMapper {

    fun map(category: String, zone: String, apiModel: GetCentersResponse): CenterCategoryDataModel {
        return CenterCategoryDataModel(
            category,
            zone,
            apiModel.centers.map {
                CenterCategoryModel(
                    it.url,
                    it.title,
                    it.location.latitude,
                    it.location.longitude
                )
            })
    }
}