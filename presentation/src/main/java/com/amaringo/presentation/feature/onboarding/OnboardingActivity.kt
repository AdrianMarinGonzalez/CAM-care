package com.amaringo.presentation.feature.onboarding

import com.amaringo.presentation.base.BaseActivity
import com.amaringo.presentation.R
import com.amaringo.presentation.databinding.OnboardingActivityBinding
import com.amaringo.presentation.feature.onboarding.di.onboardingModule
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.loadKoinModules

class OnboardingActivity: BaseActivity<OnboardingActivityBinding>() {

    override fun getLayoutId() = R.layout.onboarding_activity

    override fun setBinding() {
        dataBinding.viewModel = getViewModel()
    }

    override fun initViews() {

    }

    override fun injectFeatures() {
        loadKoinModules(onboardingModule)
    }
}
