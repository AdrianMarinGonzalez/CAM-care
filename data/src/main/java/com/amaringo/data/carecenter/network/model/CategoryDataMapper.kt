package com.amaringo.data.carecenter.network.model

import com.amaringo.data.carecenter.model.CategoryDataModel
import com.amaringo.data.carecenter.model.CenterCategoryModel

class CategoryDataMapper {

    fun map(category: String, zone: String, apiModel: GetCentersResponse): CategoryDataModel {
        return CategoryDataModel(
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