package com.amaringo.presentation.feature.center_list

import com.amaringo.domain.centers.GetCentersUseCase
import com.amaringo.presentation.base.BaseViewModel


class CenterCategoryListViewModel(val getCentersUseCase: GetCentersUseCase): BaseViewModel() {

    fun getCenters() {

    }

    override fun onDestroy() {
        getCentersUseCase.destroy()
    }
}