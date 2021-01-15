package com.amaringo.data.carecenter.db

import android.content.Context
import androidx.room.Room
import com.amaringo.data.carecenter.db.model.CenterCategoryDataMapper
import com.amaringo.data.carecenter.db.model.CenterCategoryEntity
import com.amaringo.data.carecenter.model.CenterCategoryDataModel

class CAMCareDatabaseClient(applicationContext: Context, val mapper: CenterCategoryDataMapper) {
    private val db = Room.databaseBuilder(
        applicationContext,
        CAMCareDatabase::class.java, "camcaredb"
    ).build()

    fun getCenterCategoryDataModelByZoneAndCategory(
        zone: String,
        category: String
    ): CenterCategoryDataModel {
        val dao = db.centerCategoryDao()
        val entity = dao.findCategoryDataByZoneAndCategory(zone, category).also {
            it.centers = dao.loadCentersFromCategory(it.uid)
        }
        val dto = mapper.map(category, zone, entity)
        return dto
    }

    fun saveCenterCategoryDataModel(model: CenterCategoryDataModel) {
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