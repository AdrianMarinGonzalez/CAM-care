package com.amaringo.camcare

import com.amaringo.domain.base.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SchedulerProviderImpl: SchedulerProvider {
    override fun observeTarget() = AndroidSchedulers.mainThread()
    override fun subscribeTarget() = Schedulers.io()
}