package com.amaringo.presentation.feature.center_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amaringo.presentation.base.BaseViewModel
import com.amaringo.presentation.feature.center_detail.model.CenterDetail
import com.amaringo.presentation.feature.center_list.model.CenterCategory


class CenterDetailViewModel() : BaseViewModel() {

    private val _centerData = MutableLiveData<CenterDetail>()
    val centerData: LiveData<CenterDetail> = _centerData

    fun getCenter(center: CenterCategory) {

    }

    override fun onDestroy() {
    }
}