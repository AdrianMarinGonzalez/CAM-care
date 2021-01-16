package com.amaringo.data.carecenter.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CenterEntity(
    @ColumnInfo var url: String = "",
    @ColumnInfo var title: String = "",
    @ColumnInfo var schedule: String = "",
    @ColumnInfo var address: String = "",
    @ColumnInfo var description: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0
}