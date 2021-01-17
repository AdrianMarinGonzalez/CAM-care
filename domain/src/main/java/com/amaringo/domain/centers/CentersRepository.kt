package com.amaringo.domain.centers

import com.amaringo.domain.model.CategoryDataDTO
import com.amaringo.domain.model.CenterDetailDTO
import io.reactivex.Observable
import io.reactivex.Single


interface CentersRepository {
    fun getCenters(zone: String): Observable<CategoryDataDTO>
    fun getCenter(url: String): Single<CenterDetailDTO>
}