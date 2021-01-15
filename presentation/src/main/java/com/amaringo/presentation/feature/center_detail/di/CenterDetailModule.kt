package com.amaringo.presentation.feature.center_detail.di

import com.amaringo.presentation.feature.center_detail.CenterDetailViewModel
import com.amaringo.presentation.feature.center_detail.model.CenterDetailMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val centerDetailModule = module {

    single { CenterDetailMapper(get()) }

    viewModel {
        CenterDetailViewModel()
    }
}