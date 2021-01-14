package com.amaringo.domain.centers

import com.amaringo.domain.base.BaseUseCase
import io.reactivex.Scheduler


class GetCentersUseCase(
    observeScheduler: Scheduler,
    subscribeScheduler: Scheduler
) : BaseUseCase(observeScheduler, subscribeScheduler) {

    fun getCenters() {

    }
}