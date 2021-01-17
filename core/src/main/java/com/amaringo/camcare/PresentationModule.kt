package com.amaringo.camcare

import com.amaringo.presentation.common.StringLoader
import com.amaringo.presentation.feature.center_detail.CenterDetailViewModel
import com.amaringo.presentation.feature.center_detail.model.CenterDetailMapper
import com.amaringo.presentation.feature.center_list.CenterCategoryListViewModel
import com.amaringo.presentation.feature.center_list.model.CenterCategoryMapper
import com.amaringo.presentation.feature.onboarding.OnboardingViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single { StringLoader(androidContext()) }

    single { CenterCategoryMapper(get()) }

    viewModel {
        CenterCategoryListViewModel(get(), get(), get())
    }

    single { CenterDetailMapper() }

    viewModel {
        CenterDetailViewModel(get(), get(), get())
    }

    viewModel {
        OnboardingViewModel()
    }
}
