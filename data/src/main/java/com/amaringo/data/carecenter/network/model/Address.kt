package com.amaringo.data.carecenter.network.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("street-address") val street: String
)