package com.amaringo.domain.base

import io.reactivex.Scheduler


interface SchedulerProvider {
    fun observeTarget(): Scheduler
    fun subscribeTarget(): Scheduler
}