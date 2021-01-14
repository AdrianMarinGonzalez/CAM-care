package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.network.model.GetCentersBody
import com.amaringo.data.carecenter.network.model.GetCentersResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET


interface CentersApi {

    @GET("/catalogo/200337-0-centros-mayores.json")
    fun getSeniorCenters(@Body body: GetCentersBody): Call<GetCentersResponse>

    @GET("/catalogo/205244-0-infancia-familia-adolescentes.json")
    fun getChildrenShelterCenters(@Body body: GetCentersBody): Call<GetCentersResponse>

    @GET("/catalogo/209094-0-centros-servicios-sociales.json")
    fun getSocialServicesCenters(@Body body: GetCentersBody): Call<GetCentersResponse>

    @GET("/catalogo/200342-0-centros-dia.json")
    fun getDayCareCenters(@Body body: GetCentersBody): Call<GetCentersResponse>
}