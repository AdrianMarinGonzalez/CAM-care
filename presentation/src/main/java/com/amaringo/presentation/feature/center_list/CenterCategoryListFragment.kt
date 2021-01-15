package com.amaringo.presentation.feature.center_list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseFragment
import com.amaringo.presentation.common.addLifecyclerObserver
import com.amaringo.presentation.databinding.CenterListFragmentBinding
import com.amaringo.presentation.feature.center_list.di.centerListModule
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.loadKoinModules


class CenterCategoryListFragment: BaseFragment<CenterCategoryListViewModel, CenterListFragmentBinding>() {

    override fun getLayoutId() = R.layout.center_list_fragment

    override fun getInjectionModules() = listOf(centerListModule)

    override fun initViews() {
        addLifecyclerObserver(viewModel.centersData) {
            (dataBinding.contentList.adapter as CenterCategoryListAdapter).update(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCenters()
    }

    override fun setBinding() {
        viewModel = getViewModel()
        dataBinding.contentList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CenterCategoryListAdapter(mutableListOf())
        }
    }
}