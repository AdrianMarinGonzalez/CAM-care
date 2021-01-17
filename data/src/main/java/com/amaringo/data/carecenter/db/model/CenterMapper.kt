package com.amaringo.data.carecenter.db.model

import com.amaringo.data.carecenter.model.CenterDetailModel


class CenterMapper {
    fun map(entity: CenterEntity) =
        CenterDetailModel(entity.url, entity.title, entity.schedule, entity.address, entity.description)

    fun map(model: CenterDetailModel) =
        CenterEntity(model.url, model.title, model.schedule, model.address, model.description)
}