package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.model.CategoryDataModel
import com.amaringo.data.carecenter.model.CenterDetailModel
import io.reactivex.Single


interface CentersService {

    fun getSeniorCenters(zone: String): Single<CategoryDataModel>
    fun getChildrenShelterCenters(zone: String): Single<CategoryDataModel>
    fun getSocialServicesCenters(zone: String): Single<CategoryDataModel>
    fun getDayCareCenters(zone: String): Single<CategoryDataModel>

    fun getCenter(url: String): Single<CenterDetailModel>
}