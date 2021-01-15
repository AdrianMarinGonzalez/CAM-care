package com.amaringo.data.carecenter.db.model

import androidx.room.*

@Entity
data class CenterCategoryDataEntity(
    @ColumnInfo(name = "category") var category: String = "",
    @ColumnInfo(name = "zone") var zone: String = "",

    @Ignore var centers: List<CenterCategoryEntity> = emptyList()
){
    @PrimaryKey(autoGenerate = true) var uid: Long = 0
}