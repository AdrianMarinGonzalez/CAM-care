package com.amaringo.presentation.feature.center_detail.model

import com.amaringo.domain.model.CenterDetailDTO

class CenterDetailMapper {
    fun map(model: CenterDetailDTO) = CenterDetail(model.title, model.schedule, model.address, model.description)
}