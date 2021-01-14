package com.amaringo.presentation.feature.center_list

import androidx.recyclerview.widget.LinearLayoutManager
import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseFragment
import com.amaringo.presentation.databinding.CenterListFragmentBinding
import com.amaringo.presentation.feature.center_list.di.centerListModule
import com.amaringo.presentation.feature.center_list.model.Culture
import com.amaringo.presentation.feature.center_list.model.ChildrenShelter
import com.amaringo.presentation.feature.center_list.model.Senior
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.loadKoinModules


class CenterCategoryListFragment: BaseFragment<CenterCategoryListViewModel, CenterListFragmentBinding>() {

    override fun getLayoutId() = R.layout.center_list_fragment

    override fun getInjectionModules() = listOf(centerListModule)

    override fun initViews() {
    }

    override fun setBinding() {
        viewModel = getViewModel()
        dataBinding.contentList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CenterCategoryListAdapter(listOf(
                Senior("1", "SENIOR CENTER", ""),
                Culture("2", "CULTURE CENTER", ""),
                ChildrenShelter("3", "SHELTER CENTER", "")
            ))
        }
    }
}