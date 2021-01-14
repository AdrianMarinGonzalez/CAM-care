package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.network.model.GetCentersBody


interface CentersService {

    fun getSeniorCenters(zone: String, callback: CentersServiceCallback)
    fun getChildrenShelterCenters(zone: String, callback: CentersServiceCallback)
    fun getSocialServicesCenters(zone: String, callback: CentersServiceCallback)
    fun getDayCareCenters(zone: String, callback: CentersServiceCallback)
}