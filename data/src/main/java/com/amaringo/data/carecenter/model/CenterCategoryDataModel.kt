package com.amaringo.data.carecenter.model

data class CenterCategoryDataModel(
    val category: String,
    val zone: String,
    val centers: List<CenterCategoryModel>
)