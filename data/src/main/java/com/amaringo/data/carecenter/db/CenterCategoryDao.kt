package com.amaringo.data.carecenter.db

import androidx.room.*
import com.amaringo.data.carecenter.db.model.CenterCategoryDataEntity
import com.amaringo.data.carecenter.db.model.CenterCategoryEntity
import io.reactivex.Single

@Dao
interface CenterCategoryDao {

    @Query("SELECT * FROM CenterCategoryDataEntity")
    fun getAll(): List<CenterCategoryDataEntity>

    @Query("SELECT * FROM CenterCategoryDataEntity WHERE category LIKE :category AND zone LIKE :zone LIMIT 1")
    fun findCategoryDataByZoneAndCategory(zone: String, category: String): CenterCategoryDataEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(models: List<CenterCategoryDataEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoryData(model: CenterCategoryDataEntity): Long

    @Delete
    fun delete(model: CenterCategoryDataEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCenters(centers: List<CenterCategoryEntity>)

    @Transaction
    @Query("SELECT * FROM CenterCategoryEntity WHERE categoryId == :categoryId")
    fun loadCentersFromCategory(categoryId: Long): List<CenterCategoryEntity>
}