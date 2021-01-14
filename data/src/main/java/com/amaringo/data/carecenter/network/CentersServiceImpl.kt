package com.amaringo.data.carecenter.network

import com.amaringo.data.carecenter.network.model.GetCentersBody
import com.amaringo.data.carecenter.network.model.GetCentersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CentersServiceImpl constructor(private val apiClient: CentersApi) : CentersService {

    override fun getSeniorCenters(zone: String, callback: CentersServiceCallback) {
        val call: Call<GetCentersResponse> = apiClient.getSeniorCenters(GetCentersBody(zone))
        call.enqueue(object : Callback<GetCentersResponse> {
            override fun onFailure(call: Call<GetCentersResponse>, t: Throwable) {
                callback.onCallFailed()
            }

            override fun onResponse(
                call: Call<GetCentersResponse>,
                response: Response<GetCentersResponse>
            ) {
                if (response.isSuccessful && response.body() != null)
                    callback.onCentersReceived(response.body() as GetCentersResponse)
                else callback.onCallFailed()
            }

        })
    }

    override fun getChildrenShelterCenters(zone: String, callback: CentersServiceCallback) {
        val call: Call<GetCentersResponse> = apiClient.getChildrenShelterCenters(GetCentersBody(zone))
        call.enqueue(object : Callback<GetCentersResponse> {
            override fun onFailure(call: Call<GetCentersResponse>, t: Throwable) {
                callback.onCallFailed()
            }

            override fun onResponse(
                call: Call<GetCentersResponse>,
                response: Response<GetCentersResponse>
            ) {
                if (response.isSuccessful && response.body() != null)
                    callback.onCentersReceived(response.body() as GetCentersResponse)
                else callback.onCallFailed()
            }

        })
    }

    override fun getSocialServicesCenters(zone: String, callback: CentersServiceCallback) {
        val call: Call<GetCentersResponse> = apiClient.getSocialServicesCenters(GetCentersBody(zone))
        call.enqueue(object : Callback<GetCentersResponse> {
            override fun onFailure(call: Call<GetCentersResponse>, t: Throwable) {
                callback.onCallFailed()
            }

            override fun onResponse(
                call: Call<GetCentersResponse>,
                response: Response<GetCentersResponse>
            ) {
                if (response.isSuccessful && response.body() != null)
                    callback.onCentersReceived(response.body() as GetCentersResponse)
                else callback.onCallFailed()
            }

        })
    }

    override fun getDayCareCenters(zone: String, callback: CentersServiceCallback) {
        val call: Call<GetCentersResponse> = apiClient.getDayCareCenters(GetCentersBody(zone))
        call.enqueue(object : Callback<GetCentersResponse> {
            override fun onFailure(call: Call<GetCentersResponse>, t: Throwable) {
                callback.onCallFailed()
            }

            override fun onResponse(
                call: Call<GetCentersResponse>,
                response: Response<GetCentersResponse>
            ) {
                if (response.isSuccessful && response.body() != null)
                    callback.onCentersReceived(response.body() as GetCentersResponse)
                else callback.onCallFailed()
            }

        })
    }
}