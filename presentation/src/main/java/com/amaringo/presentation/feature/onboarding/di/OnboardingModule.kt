package com.amaringo.presentation.feature.onboarding.di

import com.amaringo.presentation.feature.onboarding.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {
    viewModel {
        OnboardingViewModel()
    }
}