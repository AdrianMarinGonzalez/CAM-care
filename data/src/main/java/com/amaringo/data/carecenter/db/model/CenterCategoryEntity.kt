package com.amaringo.data.carecenter.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity
data class CenterCategoryEntity(
    @ColumnInfo var id: String = "",
    @ColumnInfo var title: String = "",
    @ColumnInfo var latitude: Double = 0.0,
    @ColumnInfo var longitude: Double = 0.0,
    @ForeignKey(
        entity = CenterCategoryDataEntity::class,
        parentColumns = ["uid"],
        childColumns = ["categoryId"],
        onDelete = ForeignKey.CASCADE
    )
    var categoryId: Long = 0
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0
}