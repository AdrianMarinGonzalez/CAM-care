package com.amaringo.data.carecenter.network.model

import com.google.gson.annotations.SerializedName


data class GetCentersItem(@SerializedName("@id") val url: String, val title: String, val location: Location)