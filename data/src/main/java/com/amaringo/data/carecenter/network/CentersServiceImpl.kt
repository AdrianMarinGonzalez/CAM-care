package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.network.model.CategoryDataMapper
import com.amaringo.data.carecenter.model.CategoryDataModel
import com.amaringo.data.carecenter.model.CenterDetailModel
import com.amaringo.data.carecenter.network.model.CenterDetailMapper
import io.reactivex.Single


class CentersServiceImpl constructor(
    apiClient: APIClient,
    private val categoryMapper: CategoryDataMapper,
    private val detailMapper: CenterDetailMapper
) : CentersService {

    private val service: CentersApi = apiClient.createService(CentersApi::class.java)

    override fun getSeniorCenters(zone: String): Single<CategoryDataModel> {
        return service.getSeniorCenters(zone)
            .map { categoryMapper.map("SENIOR", zone, it) }
    }

    override fun getChildrenShelterCenters(zone: String): Single<CategoryDataModel> {
        return service.getChildrenShelterCenters(zone)
            .map { categoryMapper.map("CHILDREN_SHELTER", zone, it) }
    }

    override fun getSocialServicesCenters(zone: String): Single<CategoryDataModel> {
        return service.getSocialServicesCenters(zone)
            .map { categoryMapper.map("SOCIAL_SERVICES", zone, it) }
    }

    override fun getDayCareCenters(zone: String): Single<CategoryDataModel> {
        return service.getDayCareCenters(zone)
            .map { categoryMapper.map("DAY_CARE", zone, it) }
    }

    override fun getCenter(url: String): Single<CenterDetailModel> {
        return service.getCenterDetail(url).map { detailMapper.map(it) }
    }
}