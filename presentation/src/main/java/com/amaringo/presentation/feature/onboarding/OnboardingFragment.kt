package com.amaringo.presentation.feature.onboarding

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseFragment
import com.amaringo.presentation.common.SpinnerAdapter
import com.amaringo.presentation.databinding.OnboardingFragmentLayoutBinding
import com.amaringo.presentation.model.Error
import org.koin.androidx.viewmodel.ext.android.getViewModel
import com.amaringo.presentation.common.ZONE_ARGUMENT_KEY


class OnboardingFragment: BaseFragment<OnboardingViewModel, OnboardingFragmentLayoutBinding>() {

    override fun getLayoutId() = R.layout.onboarding_fragment_layout

    override fun setBinding() {
        viewModel = getViewModel()
        dataBinding.onContinue = View.OnClickListener {
            navigateTo(R.id.centerListFragment, R.id.onboardingFragment, bundleOf(ZONE_ARGUMENT_KEY to viewModel.zone))
        }
    }

    override fun initViews() {
        with(dataBinding.zoneSelectionSpinner) {
            val items = resources.getStringArray(R.array.zones)
            adapter = SpinnerAdapter(context, android.R.layout.simple_spinner_dropdown_item, items.toList())
            onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(adapterView: AdapterView<*>?) {}

                override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                    viewModel.zone = items[position]
                }
            }
            setSelection(0)
        }
    }

    override fun showError(error: Error) {}
}