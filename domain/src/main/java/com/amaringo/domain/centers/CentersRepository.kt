package com.amaringo.domain.centers

import com.amaringo.domain.model.CenterDataDTO
import io.reactivex.Observable
import io.reactivex.Single


interface CentersRepository {
    fun getCenters(zone: String): Observable<List<CenterDataDTO>>
}