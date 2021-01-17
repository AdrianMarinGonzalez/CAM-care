package com.amaringo.data.carecenter

import com.amaringo.data.carecenter.db.CAMCareDatabaseClient
import com.amaringo.data.carecenter.model.CategoryDataMapper
import com.amaringo.data.carecenter.model.CategoryDataModel
import com.amaringo.data.carecenter.model.CenterDetailMapper
import com.amaringo.data.carecenter.network.CentersService
import com.amaringo.domain.centers.CentersRepository
import com.amaringo.domain.model.CategoryDataDTO
import com.amaringo.domain.model.CenterDetailDTO
import io.reactivex.Observable
import io.reactivex.Single


class CentersRepositoryImplementation(
    private val api: CentersService,
    private val dbClient: CAMCareDatabaseClient,
    private val categoryDataMapper: CategoryDataMapper,
    private val centerDetailMapper: CenterDetailMapper
) : CentersRepository {

    override fun getCenters(zone: String): Observable<CategoryDataDTO> {

        return Observable.merge(
            getSeniorCenters(zone),
            getChildrenShelters(zone),
            getSocialServicesCenters(zone),
            getDayCareCenters(zone)
        )
    }

    override fun getCenter(url: String): Single<CenterDetailDTO> {
        return getAPICenter(url).onErrorResumeNext { getDBCenter(url) }
    }

    private fun getAPICenter(url: String): Single<CenterDetailDTO> {
        return api.getCenter(url).doOnSuccess { dbClient.saveCenterModel(it) }
            .map { centerDetailMapper.map(it) }

    }

    private fun getDBCenter(url: String) = Single.create<CenterDetailDTO> { emitter ->
        run {
            val entity = dbClient.findCenterByUrl(url)
            entity?.let {
                val model = centerDetailMapper.map(entity)
                emitter.onSuccess(model)
            } ?: run {
                emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
            }
        }
    }

    private fun getSeniorCenters(zone: String): Observable<CategoryDataDTO> {
        return api.getSeniorCenters(zone)
            .doOnSuccess {
                if (it.centers.isNotEmpty()) dbClient.saveCenterCategoryDataModel(it)
            }
            .onErrorResumeNext(getDBSeniorCenters(zone))
            .toObservable()
            .flatMap {
                if (it.centers.isEmpty()) Observable.empty<CategoryDataDTO?>()
                else Observable.just(categoryDataMapper.map("SENIOR", zone, it))
            }
    }

    private fun getDBSeniorCenters(zone: String) = Single.create<CategoryDataModel> { emitter ->
        run {
            dbClient.findCenterCategoryDataModelByZoneAndCategory(zone, "SENIOR")?.let {
                emitter.onSuccess(it)
            } ?: run {
                emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
            }
        }
    }

    private fun getChildrenShelters(zone: String): Observable<CategoryDataDTO> {
        return api.getChildrenShelterCenters(zone)
            .doOnSuccess {
                if (it.centers.isNotEmpty()) dbClient.saveCenterCategoryDataModel(it)
            }
            .onErrorResumeNext(getDBChildrenShelterCenters(zone))
            .toObservable()
            .flatMap {
                if (it.centers.isEmpty()) Observable.empty<CategoryDataDTO?>()
                else Observable.just(categoryDataMapper.map("CHILDREN_SHELTER", zone, it))
            }
    }

    private fun getDBChildrenShelterCenters(zone: String) =
        Single.create<CategoryDataModel> { emitter ->
            run {
                dbClient.findCenterCategoryDataModelByZoneAndCategory(zone, "CHILDREN_SHELTER")
                    ?.let {
                        emitter.onSuccess(it)
                    } ?: run {
                    emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
                }
            }
        }

    private fun getSocialServicesCenters(zone: String): Observable<CategoryDataDTO> {
        return api.getSocialServicesCenters(zone)
            .doOnSuccess {
                if (it.centers.isNotEmpty()) dbClient.saveCenterCategoryDataModel(it)
            }
            .onErrorResumeNext(getDBSocialServicesCenters(zone))
            .toObservable()
            .flatMap {
                if (it.centers.isEmpty()) Observable.empty<CategoryDataDTO?>()
                else Observable.just(categoryDataMapper.map("SOCIAL_SERVICES", zone, it))
            }
    }

    private fun getDBSocialServicesCenters(zone: String) =
        Single.create<CategoryDataModel> { emitter ->
            run {
                dbClient.findCenterCategoryDataModelByZoneAndCategory(zone, "SOCIAL_SERVICES")
                    ?.let {
                        emitter.onSuccess(it)
                    } ?: run {
                    emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
                }
            }
        }

    private fun getDayCareCenters(zone: String): Observable<CategoryDataDTO> {
        return api.getDayCareCenters(zone)
            .doOnSuccess {
                if (it.centers.isNotEmpty()) dbClient.saveCenterCategoryDataModel(it)
            }
            .onErrorResumeNext(getDBDayCareCenters(zone))
            .toObservable()
            .flatMap {
                if (it.centers.isEmpty()) Observable.empty<CategoryDataDTO?>()
                else Observable.just(categoryDataMapper.map("DAY_CARE", zone, it))
            }
    }

    private fun getDBDayCareCenters(zone: String) = Single.create<CategoryDataModel> { emitter ->
        run {
            dbClient.findCenterCategoryDataModelByZoneAndCategory(zone, "DAY_CARE")?.let {
                emitter.onSuccess(it)
            } ?: run {
                emitter.onError(Throwable("El recurso al que ha intentado acceder no está disponible en estos momentos"))
            }
        }
    }
}