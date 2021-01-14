package com.amaringo.data.carecenter.network.model

data class GetCentersResponseItem(
    val address: Address,
    val description: String,
    val dtend: String,
    val dtstart: String,
    val id: String,
    val link: String,
    val location: Location,
    val organization: Organization,
    val price: Int,
    val recurrence: Recurrence,
    val references: String,
    val relation: String,
    val title: String,
    val uid: String
)