package com.amaringo.data.carecenter.network.model

import com.amaringo.data.carecenter.model.CenterDetailModel


class CenterDetailMapper {

    fun map(apiModel: GetCenterDetailResponse) = CenterDetailModel(
            apiModel.centers[0].title,
            apiModel.centers[0].organization.schedule,
            apiModel.centers[0].address.street,
            apiModel.centers[0].organization.services
        )
}