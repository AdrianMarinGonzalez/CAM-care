package com.amaringo.data.carecenter

import com.amaringo.domain.centers.CentersRepository
import com.amaringo.domain.model.CenterDataDTO
import io.reactivex.Single


class CentersRepositoryImplementation: CentersRepository {
    override fun getCenters(zone: String): Single<CenterDataDTO> {
        return Single.create { emitter ->  emitter.onSuccess(CenterDataDTO("", emptyList()))}
    }
}