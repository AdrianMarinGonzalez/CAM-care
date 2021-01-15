package com.amaringo.camcare

import com.amaringo.data.carecenter.CenterDataMapper
import com.amaringo.data.carecenter.CentersRepositoryImplementation
import com.amaringo.data.carecenter.db.CAMCareDatabaseClient
import com.amaringo.data.carecenter.db.model.CenterCategoryDataMapper
import com.amaringo.data.carecenter.network.APIClient
import com.amaringo.data.carecenter.network.CentersService
import com.amaringo.data.carecenter.network.CentersServiceImpl
import com.amaringo.domain.centers.CentersRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single { CenterDataMapper() }
    single { CenterCategoryDataMapper() }
    single { com.amaringo.data.carecenter.network.model.CenterCategoryDataMapper() }

    single { CAMCareDatabaseClient(androidContext(), get()) }
    single { APIClient("https://datos.madrid.es/") }
    factory<CentersService> { CentersServiceImpl(get(), get()) }

    factory<CentersRepository> { CentersRepositoryImplementation(get(), get(), get()) }
}