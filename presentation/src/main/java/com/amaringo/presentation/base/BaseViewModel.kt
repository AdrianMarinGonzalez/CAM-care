package com.amaringo.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amaringo.presentation.model.ScreenFlowState

abstract class BaseViewModel: ViewModel() {

    protected var _screenState = MutableLiveData<ScreenFlowState>()
    val screenState: LiveData<ScreenFlowState> = _screenState

}