package com.amaringo.data.carecenter.network.model

import com.google.gson.annotations.SerializedName


data class GetCenterDetailResponse(@SerializedName("@graph") val centers: ArrayList<GetCenterDetailItem>)

data class GetCenterDetailItem(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("relation") val relation : String,
    @SerializedName("address") val address : Address,
    @SerializedName("location") val location : Location,
    @SerializedName("organization") val organization : Organization
)