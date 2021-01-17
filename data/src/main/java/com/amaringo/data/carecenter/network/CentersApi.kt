package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.network.model.GetCenterDetailResponse
import com.amaringo.data.carecenter.network.model.GetCentersResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface CentersApi {

    @GET("egob/catalogo/200337-0-centros-mayores.json")
    fun getSeniorCenters(@Query("distrito_nombre") zone: String): Single<GetCentersResponse>

    @GET("egob/catalogo/205244-0-infancia-familia-adolescentes.json")
    fun getChildrenShelterCenters(@Query("distrito_nombre") zone: String): Single<GetCentersResponse>

    @GET("egob/catalogo/209094-0-centros-servicios-sociales.json")
    fun getSocialServicesCenters(@Query("distrito_nombre") zone: String): Single<GetCentersResponse>

    @GET("egob/catalogo/200342-0-centros-dia.json")
    fun getDayCareCenters(@Query("distrito_nombre") zone: String): Single<GetCentersResponse>

    @GET
    fun getCenterDetail(@Url endpoint: String): Single<GetCenterDetailResponse>
}