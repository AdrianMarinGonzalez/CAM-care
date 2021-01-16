package com.amaringo.data.carecenter.db

import android.content.Context
import androidx.room.Room
import com.amaringo.data.carecenter.db.model.CategoryDataMapper
import com.amaringo.data.carecenter.db.model.CenterCategoryEntity
import com.amaringo.data.carecenter.model.CategoryDataModel

class CAMCareDatabaseClient(applicationContext: Context, val mapper: CategoryDataMapper) {
    private val db = Room.databaseBuilder(
        applicationContext,
        CAMCareDatabase::class.java, "camcaredb"
    ).build()

    fun getCenterCategoryDataModelByZoneAndCategory(
        zone: String,
        category: String
    ): CategoryDataModel {
        val dao = db.centerCategoryDao()
        val entity = dao.findCategoryDataByZoneAndCategory(zone, category).also {
            it.centers = dao.loadCentersFromCategory(it.uid)
        }
        val dto = mapper.map(category, zone, entity)
        return dto
    }

    fun saveCenterCategoryDataModel(model: CategoryDataModel) {
        val dao = db.centerCategoryDao()
        val entity = mapper.map(model)
        val insertedId = dao.insertCategoryData(entity)
        saveCentersForCategory(insertedId ,entity.centers)
    }

    private fun saveCentersForCategory(
        categoryId: Long,
        centers: List<CenterCategoryEntity>
    ) {
        val dao = db.centerCategoryDao()
        centers.forEach{ center: CenterCategoryEntity -> center.categoryId = categoryId }
        dao.insertCenters(centers)
    }


}