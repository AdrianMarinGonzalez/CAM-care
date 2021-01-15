package com.amaringo.presentation.feature.center_list.di

import com.amaringo.domain.centers.GetCentersUseCase
import com.amaringo.presentation.common.StringLoader
import com.amaringo.presentation.feature.center_list.CenterCategoryListViewModel
import com.amaringo.presentation.feature.center_list.model.CenterCategoryMapper
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.core.qualifier.named

val centerListModule = module {

    factory { GetCentersUseCase(
        get(),
        get(qualifier = named("MAIN_SCHEDULER")),
        get(qualifier = named("IO_SCHEDULER"))
    )}

    single { CenterCategoryMapper(get()) }

    viewModel {
        CenterCategoryListViewModel(get(), get())
    }
}