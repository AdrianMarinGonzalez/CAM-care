package com.amaringo.data.carecenter.db

import androidx.room.*
import com.amaringo.data.carecenter.db.model.CenterCategoryDataEntity
import com.amaringo.data.carecenter.db.model.CenterCategoryEntity
import com.amaringo.data.carecenter.db.model.CenterEntity

@Dao
interface CenterDao {

    @Query("SELECT * FROM CenterEntity WHERE url LIKE :url LIMIT 1")
    fun findByUrl(url: String): CenterEntity?

    @Query("SELECT * FROM CenterEntity")
    fun getAll(): List<CenterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: CenterEntity)

    @Delete
    fun delete(model: CenterEntity)

}
