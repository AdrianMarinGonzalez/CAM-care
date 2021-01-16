package com.amaringo.presentation.feature.center_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amaringo.domain.centers.CentersUseCase
import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseViewModel
import com.amaringo.presentation.common.StringLoader
import com.amaringo.presentation.feature.center_detail.model.CenterDetail
import com.amaringo.presentation.feature.center_detail.model.CenterDetailMapper
import com.amaringo.presentation.feature.center_list.model.Center
import com.amaringo.presentation.model.Error


class CenterDetailViewModel(
    val centersUseCase: CentersUseCase,
    val centerMapper: CenterDetailMapper,
    val stringLoader: StringLoader
) : BaseViewModel() {

    private val _centerData = MutableLiveData<CenterDetail>()
    val centerData: LiveData<CenterDetail> = _centerData

    fun getCenter(center: Center) {
        centersUseCase.getCenter(center.url, createObserver(
            onDataReceived = {
                _centerData.value = centerMapper.map(it)
            },
            onFailure = {
                _error.value = Error(it.message ?: stringLoader.load(R.string.generic_error))
            }
        ))
    }

    override fun onDestroy() {
        centersUseCase.destroy()
    }
}