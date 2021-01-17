package com.amaringo.data.carecenter.network.model

import com.google.gson.annotations.SerializedName


data class GetCenterDetailResponse(@SerializedName("@graph") val centers: ArrayList<GetCenterDetailItem>)

data class GetCenterDetailItem(
    @SerializedName("@id") val url : String,
    @SerializedName("title") val title : String,
    @SerializedName("address") val address : Address,
    @SerializedName("organization") val organization : Organization
)