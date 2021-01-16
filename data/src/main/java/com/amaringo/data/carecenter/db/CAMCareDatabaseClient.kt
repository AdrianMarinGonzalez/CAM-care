package com.amaringo.data.carecenter.db

import android.content.Context
import androidx.room.Room
import com.amaringo.data.carecenter.db.model.CategoryDataMapper
import com.amaringo.data.carecenter.db.model.CenterCategoryEntity
import com.amaringo.data.carecenter.db.model.CenterEntity
import com.amaringo.data.carecenter.db.model.CenterMapper
import com.amaringo.data.carecenter.model.CategoryDataModel
import com.amaringo.data.carecenter.model.CenterDetailModel

class CAMCareDatabaseClient(
    applicationContext: Context,
    val categoryMapper: CategoryDataMapper,
    val centerMapper: CenterMapper
) {

    private val db = Room.databaseBuilder(
        applicationContext,
        CAMCareDatabase::class.java, "camcaredb"
    ).build()

    fun findCenterCategoryDataModelByZoneAndCategory(
        zone: String,
        category: String
    ): CategoryDataModel {
        val dao = db.centerCategoryDao()
        val entity = dao.findCategoryDataByZoneAndCategory(zone, category).also {
            it.centers = dao.loadCentersFromCategory(it.uid)
        }
        val dto = categoryMapper.map(category, zone, entity)
        return dto
    }

    fun saveCenterCategoryDataModel(model: CategoryDataModel) {
        val dao = db.centerCategoryDao()
        val entity = categoryMapper.map(model)
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

    fun saveCenterModel(model: CenterDetailModel) {
        val dao = db.centerDao()
        val entity = centerMapper.map(model)
        dao.insert(entity)
    }

    fun findCenterByUrl(url: String): CenterDetailModel {
        val dao = db.centerDao()
        val entity = dao.findByUrl(url)
        return centerMapper.map(entity)
    }


}