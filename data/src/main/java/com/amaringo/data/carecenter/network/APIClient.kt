package com.amaringo.data.carecenter.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class APIClient constructor(private val endpoint: String, connectTimeout: Long = 10000L) {
    private val retrofitBuilder = Retrofit.Builder()
    private val client = OkHttpClient.Builder().connectTimeout(connectTimeout, TimeUnit.MILLISECONDS).build()


    fun <S> createService(serviceClass: Class<S>): S =
        retrofitBuilder
            .client(client)
            .baseUrl(endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(serviceClass)
}