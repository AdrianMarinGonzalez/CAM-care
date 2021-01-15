package com.amaringo.data.carecenter.network.model.center_categories

import com.google.gson.annotations.SerializedName

class GetCentersResponse(@SerializedName("@graph") val centers: ArrayList<GetCentersItem>)