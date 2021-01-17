package com.amaringo.domain.centers

import com.amaringo.domain.base.BaseUseCase
import com.amaringo.domain.base.SchedulerProvider
import com.amaringo.domain.base.Subscriber
import com.amaringo.domain.model.CategoryDataDTO
import com.amaringo.domain.model.CenterDetailDTO


class CentersUseCase(
    private val repository: CentersRepository,
    schedulerProvider: SchedulerProvider
) : BaseUseCase(schedulerProvider) {

    fun getCategories(zone: String, subscriber: Subscriber<CategoryDataDTO>) {
        createSubscription(repository.getCenters(zone), subscriber)
    }

    fun getCenter(url: String, subscriber: Subscriber<CenterDetailDTO>){
        createSubscription(repository.getCenter(url), subscriber)
    }
}