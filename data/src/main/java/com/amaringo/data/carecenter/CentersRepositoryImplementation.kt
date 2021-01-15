package com.amaringo.data.carecenter

import com.amaringo.data.carecenter.network.CentersService
import com.amaringo.domain.centers.CentersRepository
import com.amaringo.domain.model.CenterCategoryDataDTO
import io.reactivex.Observable


class CentersRepositoryImplementation(val api: CentersService, val mapper: CenterDataMapper): CentersRepository {
    override fun getCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return Observable.merge(
            getAPISeniorCenters(zone),
            getAPIChildrenShelterCenters(zone),
            getAPISocialServicesCenters(zone),
            getAPIDayCareCenters(zone)
        )
    }

    private fun getAPISeniorCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return api.getSeniorCenters(zone).map { mapper.map("SENIOR", it) }
    }

    private fun getAPIChildrenShelterCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return api.getChildrenShelterCenters(zone).map { mapper.map("CHILDRE_SHELTER", it) }
    }

    private fun getAPISocialServicesCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return api.getSocialServicesCenters(zone).map { mapper.map("SOCIAL_SERVICES", it) }
    }

    private fun getAPIDayCareCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return api.getDayCareCenters(zone).map { mapper.map("DAY_CARE", it) }
    }
}