package com.amaringo.domain.base

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

open class BaseUseCase constructor(private val schedulerProvider: SchedulerProvider){

    private var disposable: Disposable? = null

    fun <T> createSubscription(a: Observable<T>, subscriber: Subscriber<T>) {
        disposable = a.observeOn(schedulerProvider.observeTarget())
            .subscribeOn(schedulerProvider.subscribeTarget())
            .subscribe(
                { subscriber.onNext(it) },
                { e -> subscriber.onError(e) }
            )
    }

    fun destroy() = disposable?.dispose()
}

open class Subscriber<T> : DisposableObserver<T>() {
    override fun onNext(t: T) {}
    override fun onError(e: Throwable) {}
    override fun onComplete() {}
}