package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.network.model.GetCentersResponse

interface CentersServiceCallback {
    fun onCentersReceived(centers: GetCentersResponse)
    fun onCallFailed()
}
