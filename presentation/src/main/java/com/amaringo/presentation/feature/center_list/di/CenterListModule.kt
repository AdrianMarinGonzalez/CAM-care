package com.amaringo.presentation.feature.center_list.di

import com.amaringo.presentation.feature.center_list.CenterCategoryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val centerListModule = module {
    viewModel {
        CenterCategoryListViewModel()
    }
}