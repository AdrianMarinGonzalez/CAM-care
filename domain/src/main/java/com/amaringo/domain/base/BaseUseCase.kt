package com.amaringo.domain.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

open class BaseUseCase constructor(private val observeScheduler: Scheduler, private val subscribeScheduler: Scheduler){

    private var disposable: Disposable? = null

    fun <T> createSubscription(a: Single<T>, subscriber: Subscriber<T>) {
        disposable = a.observeOn(observeScheduler)
            .subscribeOn(subscribeScheduler)
            .subscribe(
                { subscriber.onComplete() },
                { e -> subscriber.onError(e) }
            )
    }

    fun destroy() = disposable?.dispose()

    class Subscriber<T> : DisposableObserver<T>() {
        override fun onNext(t: T) {}
        override fun onError(e: Throwable) {}
        override fun onComplete() {}
    }
}