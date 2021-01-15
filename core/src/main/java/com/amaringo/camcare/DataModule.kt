package com.amaringo.camcare

import com.amaringo.data.carecenter.CenterDataMapper
import com.amaringo.data.carecenter.CentersRepositoryImplementation
import com.amaringo.data.carecenter.network.APIClient
import com.amaringo.data.carecenter.network.CentersService
import com.amaringo.data.carecenter.network.CentersServiceImpl
import com.amaringo.domain.centers.CentersRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val data = module {

    single { APIClient("https://datos.madrid.es/") }
    single { CenterDataMapper() }
    single { com.amaringo.data.carecenter.network.model.CenterDataMapper() }

    factory<CentersService> { CentersServiceImpl(get(), get()) }

    factory<CentersRepository> { CentersRepositoryImplementation(get(), get()) }
}