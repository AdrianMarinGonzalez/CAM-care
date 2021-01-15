package com.amaringo.domain.centers

import com.amaringo.domain.model.CenterCategoryDataDTO
import io.reactivex.Observable


interface CentersRepository {
    fun getCenters(zone: String): Observable<CenterCategoryDataDTO>
}