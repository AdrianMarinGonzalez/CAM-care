package com.amaringo.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amaringo.domain.base.Subscriber
import com.amaringo.presentation.common.Action
import com.amaringo.presentation.common.Failure
import com.amaringo.presentation.model.ScreenFlowState

abstract class BaseViewModel : ViewModel() {

    protected val _screenState = MutableLiveData<ScreenFlowState>()
    val screenState: LiveData<ScreenFlowState> = _screenState

    open fun onDestroy() {}

    protected fun <T> createObserver(
        onFinnished: Action? = null,
        onFailure: Failure? = null,
        onDataReceived: ((t: T) -> Unit)? = null
    ) = object : Subscriber<T>() {

        override fun onComplete() {
            onFinnished?.invoke()
        }

        override fun onError(e: Throwable) {
            onFailure?.invoke(e)
        }

        override fun onNext(t: T) {
            onDataReceived?.invoke(t)
        }

    }
}