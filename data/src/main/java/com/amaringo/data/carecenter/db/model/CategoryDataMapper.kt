package com.amaringo.data.carecenter.db.model

import com.amaringo.data.carecenter.model.CategoryDataModel
import com.amaringo.data.carecenter.model.CenterCategoryModel

class CategoryDataMapper {

    fun map(category: String, zone: String, apiModel: CenterCategoryDataEntity): CategoryDataModel {
        return CategoryDataModel(
            category,
            zone,
            apiModel.centers.map {
                CenterCategoryModel(
                    it.id,
                    it.title,
                    it.latitude,
                    it.longitude
                )
            })
    }

    fun map(model: CategoryDataModel): CenterCategoryDataEntity {
        return CenterCategoryDataEntity(
            model.category,
            model.zone,
            model.centers.map {
                CenterCategoryEntity(
                    it.id,
                    it.title,
                    it.latitude,
                    it.longitude
                )
            })
    }
}