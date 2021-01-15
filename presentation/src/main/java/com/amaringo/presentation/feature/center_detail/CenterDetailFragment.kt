package com.amaringo.presentation.feature.center_detail

import android.os.Bundle
import android.view.View
import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseFragment
import com.amaringo.presentation.common.CENTER_DATA_ARGUMENT_KEY
import com.amaringo.presentation.common.addLifecyclerObserver
import com.amaringo.presentation.databinding.CenterListFragmentBinding
import com.amaringo.presentation.feature.center_list.model.Center
import org.koin.androidx.viewmodel.ext.android.getViewModel


class CenterDetailFragment : BaseFragment<CenterDetailViewModel, CenterListFragmentBinding>() {

    override fun getLayoutId() = R.layout.center_detail_fragment

    override fun initViews() {
        addLifecyclerObserver(viewModel.centerData) {

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
}