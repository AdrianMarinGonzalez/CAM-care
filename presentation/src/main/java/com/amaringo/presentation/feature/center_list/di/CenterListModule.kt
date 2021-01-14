package com.amaringo.presentation.feature.center_list.di

import com.amaringo.presentation.feature.center_list.CenterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val centerListModule = module {
    viewModel {
        CenterListViewModel()
    }
}