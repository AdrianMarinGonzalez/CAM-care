package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.model.CategoryDataModel
import com.amaringo.data.carecenter.model.CenterDetailModel
import io.reactivex.Observable


interface CentersService {

    fun getSeniorCenters(zone: String): Observable<CategoryDataModel>
    fun getChildrenShelterCenters(zone: String): Observable<CategoryDataModel>
    fun getSocialServicesCenters(zone: String): Observable<CategoryDataModel>
    fun getDayCareCenters(zone: String): Observable<CategoryDataModel>

    fun getCenter(url: String): Observable<CenterDetailModel>
}