package com.amaringo.data.carecenter.db

import androidx.room.*
import com.amaringo.data.carecenter.db.model.CenterCategoryEntity

@Dao
interface CenterDao {

    @Query("SELECT * FROM CenterCategoryEntity")
    fun getAll(): List<CenterCategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(models: List<CenterCategoryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: CenterCategoryEntity)

    @Delete
    fun delete(model: CenterCategoryEntity)

}
