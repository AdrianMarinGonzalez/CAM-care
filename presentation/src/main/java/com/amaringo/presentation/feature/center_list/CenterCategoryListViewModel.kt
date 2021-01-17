package com.amaringo.presentation.feature.center_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amaringo.domain.centers.CentersUseCase
import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseViewModel
import com.amaringo.presentation.common.StringLoader
import com.amaringo.presentation.feature.center_list.model.CenterCategory
import com.amaringo.presentation.feature.center_list.model.CenterCategoryMapper
import com.amaringo.presentation.model.Error


class CenterCategoryListViewModel(
    val getCentersUseCase: CentersUseCase,
    val centerMapper: CenterCategoryMapper,
    val stringLoader: StringLoader
) : BaseViewModel() {

    private val _centersData = MutableLiveData<MutableList<CenterCategory>>(mutableListOf())
    val centersData: LiveData<MutableList<CenterCategory>> = _centersData

    fun getCenters(zone: String) {
        getCentersUseCase.getCategories(zone, createObserver(
            onDataReceived = {
                val currentCenters = _centersData.value
                currentCenters!!.add(centerMapper.map(it))
                _centersData.value = currentCenters
            },
            onFailure = {
                _error.value = Error(it.message ?: stringLoader.load(R.string.generic_error))
            }
        ))
    }

    override fun onDestroy() {
        getCentersUseCase.destroy()
    }
}