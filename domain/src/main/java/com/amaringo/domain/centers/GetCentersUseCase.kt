package com.amaringo.domain.centers

import com.amaringo.domain.base.BaseUseCase
import com.amaringo.domain.base.Subscriber
import com.amaringo.domain.model.CenterCategoryDataDTO
import io.reactivex.Scheduler


class GetCentersUseCase(
    private val repository: CentersRepository,
    observeScheduler: Scheduler,
    subscribeScheduler: Scheduler
) : BaseUseCase(observeScheduler, subscribeScheduler) {

    fun getCenters(zone: String, subscriber: Subscriber<CenterCategoryDataDTO>) {
        createSubscription(repository.getCenters(zone), subscriber)
    }
}