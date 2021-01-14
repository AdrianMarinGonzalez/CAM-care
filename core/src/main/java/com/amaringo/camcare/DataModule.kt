package com.amaringo.camcare

import com.amaringo.data.carecenter.CentersRepositoryImplementation
import com.amaringo.domain.centers.CentersRepository
import org.koin.dsl.module

val data = module {
    factory<CentersRepository> { CentersRepositoryImplementation() }
}