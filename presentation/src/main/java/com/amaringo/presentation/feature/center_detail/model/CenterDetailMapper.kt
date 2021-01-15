package com.amaringo.presentation.feature.center_detail.model

import com.amaringo.domain.model.CenterCategoryDataDTO
import com.amaringo.presentation.common.StringLoader

class CenterDetailMapper(val stringResolver: StringLoader) {

    fun map(model: CenterCategoryDataDTO): CenterDetail {
        return CenterDetail("", "")
    }
}