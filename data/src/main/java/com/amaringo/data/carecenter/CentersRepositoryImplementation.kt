package com.amaringo.data.carecenter

import com.amaringo.data.carecenter.db.CAMCareDatabaseClient
import com.amaringo.data.carecenter.db.model.CenterCategoryDataEntity
import com.amaringo.data.carecenter.model.CenterCategoryDataModel
import com.amaringo.data.carecenter.network.CentersService
import com.amaringo.domain.centers.CentersRepository
import com.amaringo.domain.model.CenterCategoryDataDTO
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleEmitter
import java.util.concurrent.TimeUnit


class CentersRepositoryImplementation(
    private val api: CentersService,
    private val dbClient: CAMCareDatabaseClient,
    private val mapper: CenterDataMapper
) : CentersRepository {

    override fun getCenters(zone: String): Observable<CenterCategoryDataDTO> {
        val seniorCenters = getAPISeniorCenters(zone).onErrorResumeNext(getDBSeniorCenters(zone))
        val childrenShelterCenters =
            getAPIChildrenShelterCenters(zone).onErrorResumeNext(getDBChildrenShelterCenters(zone))
        val socialServicesCenters =
            getAPISocialServicesCenters(zone).onErrorResumeNext(getDBSocialServicesCenters(zone))
        val dayCareCenters = getAPIDayCareCenters(zone).onErrorResumeNext(getDBDayCareCenters(zone))

        return Observable.merge(
            seniorCenters, childrenShelterCenters, socialServicesCenters, dayCareCenters
        )
    }

    private fun getAPISeniorCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return api.getSeniorCenters(zone).doOnNext {
            dbClient.saveCenterCategoryDataModel(it)
        }.map { mapper.map("SENIOR", zone, it) }
    }

    private fun getDBSeniorCenters(zone: String) = Observable.create<CenterCategoryDataDTO> {
            emitter ->
                run {
                    val entity = dbClient.getCenterCategoryDataModelByZoneAndCategory(zone, "SENIOR")
                    val model = mapper.map("SENIOR", zone, entity)
                    emitter.onNext(model)
                }
    }

    private fun getAPIChildrenShelterCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return api.getChildrenShelterCenters(zone).doOnNext {
            dbClient.saveCenterCategoryDataModel(it)
        }.map { mapper.map("CHILDREN_SHELTER", zone, it) }
    }

    private fun getDBChildrenShelterCenters(zone: String) = Observable.create<CenterCategoryDataDTO> {
            emitter ->
        run {
            val entity = dbClient.getCenterCategoryDataModelByZoneAndCategory(zone, "CHILDREN_SHELTER")
            val model = mapper.map("CHILDREN_SHELTER", zone, entity)
            emitter.onNext(model)
        }
    }

    private fun getAPISocialServicesCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return api.getSocialServicesCenters(zone).doOnNext {
            dbClient.saveCenterCategoryDataModel(it)
        }.map { mapper.map("SOCIAL_SERVICES", zone, it) }
    }

    private fun getDBSocialServicesCenters(zone: String) = Observable.create<CenterCategoryDataDTO> {
            emitter ->
        run {
            val entity = dbClient.getCenterCategoryDataModelByZoneAndCategory(zone, "SOCIAL_SERVICES")
            val model = mapper.map("SOCIAL_SERVICES", zone, entity)
            emitter.onNext(model)
        }
    }

    private fun getAPIDayCareCenters(zone: String): Observable<CenterCategoryDataDTO> {
        return api.getDayCareCenters(zone).doOnNext {
            dbClient.saveCenterCategoryDataModel(it)
        }.map { mapper.map("DAY_CARE", zone, it) }
    }

    private fun getDBDayCareCenters(zone: String) = Observable.create<CenterCategoryDataDTO> {
            emitter ->
        run {
            val entity = dbClient.getCenterCategoryDataModelByZoneAndCategory(zone, "DAY_CARE")
            val model = mapper.map("DAY_CARE", zone, entity)
            emitter.onNext(model)
        }
    }
}