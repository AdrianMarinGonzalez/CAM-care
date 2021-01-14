package com.amaringo.presentation.feature.center_list

import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseFragment
import com.amaringo.presentation.databinding.CenterListFragmentBinding
import com.amaringo.presentation.feature.center_list.di.centerListModule
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.loadKoinModules


class CenterListFragment: BaseFragment<CenterListViewModel, CenterListFragmentBinding>() {

    override fun getLayoutId() = R.layout.center_list_fragment

    override fun injectFeatures() {
        loadKoinModules(centerListModule)
    }

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun setBinding() {
        viewModel = getViewModel()
    }
}