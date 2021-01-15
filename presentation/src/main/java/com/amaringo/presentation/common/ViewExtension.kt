package com.amaringo.presentation.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T> LifecycleOwner.addLifecyclerObserver(liveData: LiveData<T>, onChangeAction: ((T) -> Unit)?) {
    liveData.removeObservers(this)
    liveData.observe(this, Observer { data -> onChangeAction?.invoke(data) })
}