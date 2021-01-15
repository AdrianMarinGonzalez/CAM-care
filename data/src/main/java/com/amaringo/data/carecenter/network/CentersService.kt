package com.amaringo.data.carecenter.network

import com.amaringo.domain.model.CenterCategoryDataModel
import io.reactivex.Observable


interface CentersService {

    fun getSeniorCenters(zone: String): Observable<CenterCategoryDataModel>
    fun getChildrenShelterCenters(zone: String): Observable<CenterCategoryDataModel>
    fun getSocialServicesCenters(zone: String): Observable<CenterCategoryDataModel>
    fun getDayCareCenters(zone: String): Observable<CenterCategoryDataModel>
}