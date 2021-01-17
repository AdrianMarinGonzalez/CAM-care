package com.amaringo.data.carecenter.db.model

import androidx.room.Embedded
import androidx.room.Relation


data class CategoryDataWithCenters(
    @Embedded val categoryData: CenterCategoryDataEntity
) {
    @Relation(
        parentColumn = "uid",
        entityColumn = "categoryId",
        entity = CenterCategoryEntity::class)
        var centers: List<CenterCategoryEntity>? = null
}


