package com.amaringo.data.carecenter

import com.amaringo.data.carecenter.db.CAMCareDatabaseClient
import com.amaringo.data.carecenter.model.CategoryDataMapper
import com.amaringo.data.carecenter.model.CenterDetailMapper
import com.amaringo.data.carecenter.network.CentersService
import com.amaringo.domain.centers.CentersRepository
import com.amaringo.domain.model.CategoryDataDTO
import com.amaringo.domain.model.CenterDetailDTO
import io.reactivex.Observable


class CentersRepositoryImplementation(
    private val api: CentersService,
    private val dbClient: CAMCareDatabaseClient,
    private val categoryDataMapper: CategoryDataMapper,
    private val centerDetailMapper: CenterDetailMapper
) : CentersRepository {

    override fun getCenters(zone: String): Observable<CategoryDataDTO> {
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

    override fun getCenter(url: String): Observable<CenterDetailDTO> {
        return getAPICenter(url).onErrorResumeNext(getDBCenter(url))
    }

    private fun getAPICenter(url: String): Observable<CenterDetailDTO> {
        return api.getCenter(url).doOnNext {
            dbClient.saveCenterModel(it)
        }.map { centerDetailMapper.map(it) }
    }

    private fun getDBCenter(url: String) = Observable.create<CenterDetailDTO> { emitter ->
        run {
            val entity = dbClient.findCenterByUrl(url)
            entity?.let {
                val model = centerDetailMapper.map(entity)
                emitter.onNext(model)
            } ?: run {
                emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
            }
        }
    }

    private fun getAPISeniorCenters(zone: String): Observable<CategoryDataDTO> {
        return api.getSeniorCenters(zone).doOnNext {
            dbClient.saveCenterCategoryDataModel(it)
        }.map { categoryDataMapper.map("SENIOR", zone, it) }
    }

    private fun getDBSeniorCenters(zone: String) = Observable.create<CategoryDataDTO> { emitter ->
        run {
            val entity = dbClient.findCenterCategoryDataModelByZoneAndCategory(zone, "SENIOR")
            entity?.let {
                val model = categoryDataMapper.map("SENIOR", zone, entity)
                emitter.onNext(model)
            } ?: run {
                emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
            }
        }
    }

    private fun getAPIChildrenShelterCenters(zone: String): Observable<CategoryDataDTO> {
        return api.getChildrenShelterCenters(zone).doOnNext {
            dbClient.saveCenterCategoryDataModel(it)
        }.map { categoryDataMapper.map("CHILDREN_SHELTER", zone, it) }
    }

    private fun getDBChildrenShelterCenters(zone: String) =
        Observable.create<CategoryDataDTO> { emitter ->
            run {
                val entity =
                    dbClient.findCenterCategoryDataModelByZoneAndCategory(zone, "CHILDREN_SHELTER")
                entity?.let {
                    val model = categoryDataMapper.map("CHILDREN_SHELTER", zone, entity)
                    emitter.onNext(model)
                } ?: run {
                    emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
                }

            }
        }

    private fun getAPISocialServicesCenters(zone: String): Observable<CategoryDataDTO> {
        return api.getSocialServicesCenters(zone).doOnNext {
            dbClient.saveCenterCategoryDataModel(it)
        }.map { categoryDataMapper.map("SOCIAL_SERVICES", zone, it) }
    }

    private fun getDBSocialServicesCenters(zone: String) =
        Observable.create<CategoryDataDTO> { emitter ->
            run {
                val entity =
                    dbClient.findCenterCategoryDataModelByZoneAndCategory(zone, "SOCIAL_SERVICES")
                entity?.let {
                    val model = categoryDataMapper.map("SOCIAL_SERVICES", zone, entity)
                    emitter.onNext(model)
                } ?: run {
                    emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
                }
            }
        }

    private fun getAPIDayCareCenters(zone: String): Observable<CategoryDataDTO> {
        return api.getDayCareCenters(zone).doOnNext {
            dbClient.saveCenterCategoryDataModel(it)
        }.map { categoryDataMapper.map("DAY_CARE", zone, it) }
    }

    private fun getDBDayCareCenters(zone: String) = Observable.create<CategoryDataDTO> { emitter ->
        run {
            val entity = dbClient.findCenterCategoryDataModelByZoneAndCategory(zone, "DAY_CARE")
            entity?.let {
                val model = categoryDataMapper.map("DAY_CARE", zone, entity)
                emitter.onNext(model)
            } ?: run {
                emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
            }
        }
    }
}