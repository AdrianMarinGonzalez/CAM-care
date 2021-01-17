package com.amaringo.presentation.feature.center_detail

import android.os.Bundle
import android.view.View
import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseFragment
import com.amaringo.presentation.common.CENTER_DATA_ARGUMENT_KEY
import com.amaringo.presentation.common.ErrorDialog
import com.amaringo.presentation.common.addLifecyclerObserver
import com.amaringo.presentation.databinding.CenterDetailFragmentBinding
import com.amaringo.presentation.feature.center_list.model.Center
import com.amaringo.presentation.model.Error
import org.koin.androidx.viewmodel.ext.android.getViewModel


class CenterDetailFragment : BaseFragment<CenterDetailViewModel, CenterDetailFragmentBinding>() {

    override fun getLayoutId() = R.layout.center_detail_fragment

    override fun initViews() {
        addLifecyclerObserver(viewModel.centerData) {
            dataBinding.title.text = it.title
            dataBinding.description.text = it.description
            dataBinding.schedule.text = it.schedule
            dataBinding.address.text = it.address
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val center = arguments?.getParcelable<Center>(CENTER_DATA_ARGUMENT_KEY)!!
        viewModel.getCenter(center)
    }

    override fun setBinding() {
        viewModel = getViewModel()
    }

    override fun showError(error: Error) {
        context?.let { ErrorDialog(it, error.message) { navigateBack() }.show() }
    }
}