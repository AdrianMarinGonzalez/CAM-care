package com.amaringo.data.carecenter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amaringo.data.carecenter.db.model.CenterCategoryDataEntity
import com.amaringo.data.carecenter.db.model.CenterCategoryEntity
import com.amaringo.data.carecenter.db.model.CenterEntity

@Database(entities = [
    CenterCategoryDataEntity::class, CenterCategoryEntity::class, CenterEntity::class
], version = 1)

abstract class CAMCareDatabase : RoomDatabase() {
    abstract fun centerCategoryDao(): CenterCategoryDao
    abstract fun centerDao(): CenterDao
}