package com.amaringo.data.carecenter.model

data class CategoryDataModel(
    val category: String,
    val zone: String,
    val centers: List<CenterCategoryModel>
)