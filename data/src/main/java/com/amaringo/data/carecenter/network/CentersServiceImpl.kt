package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.network.model.CenterCategoryDataMapper
import com.amaringo.data.carecenter.model.CenterCategoryDataModel
import io.reactivex.Observable


class CentersServiceImpl constructor(
    apiClient: APIClient,
    private val mapper: CenterCategoryDataMapper
) : CentersService {

    private val service: CentersApi = apiClient.createService(CentersApi::class.java)

    override fun getSeniorCenters(zone: String): Observable<CenterCategoryDataModel> {
        return service.getSeniorCenters(zone)
            .map { mapper.map("SENIOR", zone, it) }
    }

    override fun getChildrenShelterCenters(zone: String): Observable<CenterCategoryDataModel> {
        return service.getChildrenShelterCenters(zone)
            .map { mapper.map("CHILDREN_SHELTER", zone, it) }
    }

    override fun getSocialServicesCenters(zone: String): Observable<CenterCategoryDataModel> {
        return service.getSocialServicesCenters(zone)
            .map { mapper.map("SOCIAL_SERVICES", zone, it) }
    }

    override fun getDayCareCenters(zone: String): Observable<CenterCategoryDataModel> {
        return service.getDayCareCenters(zone)
            .map { mapper.map("DAY_CARE", zone, it) }
    }
}