package com.amaringo.presentation.feature.center_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amaringo.domain.centers.GetCentersUseCase
import com.amaringo.presentation.base.BaseViewModel
import com.amaringo.presentation.feature.center_list.model.Center
import com.amaringo.presentation.feature.center_list.model.CenterCategory
import com.amaringo.presentation.feature.center_list.model.CenterCategoryMapper
import com.amaringo.presentation.model.ScreenFlowState


class CenterCategoryListViewModel(val getCentersUseCase: GetCentersUseCase, val centerMapper: CenterCategoryMapper): BaseViewModel() {

    private val _centersData = MutableLiveData<MutableList<CenterCategory>>(mutableListOf())
    val centersData: LiveData<MutableList<CenterCategory>> = _centersData

    fun getCenters() {
        getCentersUseCase.getCenters("CENTRO", createObserver(
            onDataReceived = {
                val currentCenters = _centersData.value
                currentCenters!!.add(centerMapper.map(it))
                _centersData.value = currentCenters
            },
            onFailure = {
                Log.i("","")
            }
        ))
    }

    override fun onDestroy() {
        getCentersUseCase.destroy()
    }

    fun onCenterCategorySelected(centerCategory: CenterCategory) {
        _screenState.value = ScreenFlowState.NavigateToCenterCategoryDetail(centerCategory)
    }

    fun onCenterSelected(center: Center) {
        _screenState.value = ScreenFlowState.NavigateToCenterDetail(center)
    }
}