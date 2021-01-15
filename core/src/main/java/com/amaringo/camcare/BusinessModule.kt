package com.amaringo.camcare

import com.amaringo.domain.centers.CentersUseCase
import com.amaringo.presentation.feature.center_list.model.CenterCategoryMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module


val businessModule = module {
    factory { CentersUseCase(
        get(),
        get(qualifier = named("MAIN_SCHEDULER")),
        get(qualifier = named("IO_SCHEDULER"))
    )
    }
}