package com.amaringo.domain.centers

import com.amaringo.domain.base.BaseUseCase
import com.amaringo.domain.model.CenterDataDTO
import io.reactivex.Scheduler


class GetCentersUseCase(
    val repository: CentersRepository,
    observeScheduler: Scheduler,
    subscribeScheduler: Scheduler
) : BaseUseCase(observeScheduler, subscribeScheduler) {

    fun getCenters(zone: String, subscriber: Subscriber<List<CenterDataDTO>>) {
        createSubscription(repository.getCenters(zone), subscriber)
    }
}