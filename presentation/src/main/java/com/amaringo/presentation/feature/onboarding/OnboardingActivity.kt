package com.amaringo.presentation.feature.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.amaringo.presentation.base.BaseActivity
import com.amaringo.presentation.R
import com.amaringo.presentation.base.MainActivity
import com.amaringo.presentation.databinding.OnboardingActivityBinding

class OnboardingActivity : BaseActivity<OnboardingActivityBinding>() {

    override fun getLayoutId() = R.layout.onboarding_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }

    override fun setBinding() {
        dataBinding.onContinue = View.OnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun initViews() {}
}
