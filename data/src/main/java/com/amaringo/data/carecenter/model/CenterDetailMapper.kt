package com.amaringo.data.carecenter.model

import com.amaringo.domain.model.*


class CenterDetailMapper {

    fun map(model: CenterDetailModel) =
        CenterDetailDTO(model.title, model.schedule, model.address, model.description)
}