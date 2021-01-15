package com.amaringo.data.carecenter.network.model.center_categories

import com.amaringo.data.carecenter.network.model.Location
import com.google.gson.annotations.SerializedName


data class GetCentersItem(@SerializedName("@id") val url: String, val title: String, val location: Location)