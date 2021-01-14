package com.amaringo.presentation.feature.center_list.di

import com.amaringo.domain.centers.GetCentersUseCase
import com.amaringo.presentation.feature.center_list.CenterCategoryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.core.qualifier.named

val centerListModule = module {

    factory { GetCentersUseCase(
        get(qualifier = named("MAIN_SCHEDULER")),
        get(qualifier = named("IO_SCHEDULER"))
    )}

    viewModel {
        CenterCategoryListViewModel(get())
    }
}