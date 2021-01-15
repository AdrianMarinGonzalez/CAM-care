package com.amaringo.data.carecenter.db.model

import com.amaringo.data.carecenter.model.CenterCategoryDataModel
import com.amaringo.data.carecenter.model.CenterCategoryModel

class CenterCategoryDataMapper {

    fun map(category: String, zone: String, apiModel: CenterCategoryDataEntity): CenterCategoryDataModel {
        return CenterCategoryDataModel(
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

    fun map(model: CenterCategoryDataModel): CenterCategoryDataEntity {
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