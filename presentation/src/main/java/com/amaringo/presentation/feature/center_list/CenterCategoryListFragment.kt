package com.amaringo.presentation.feature.center_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaringo.presentation.R
import com.amaringo.presentation.base.BaseFragment
import com.amaringo.presentation.common.CENTER_DATA_ARGUMENT_KEY
import com.amaringo.presentation.common.ErrorDialog
import com.amaringo.presentation.common.VerticalSpaceItemDecoration
import com.amaringo.presentation.common.addLifecyclerObserver
import com.amaringo.presentation.databinding.CenterListFragmentBinding
import com.amaringo.presentation.feature.center_list.view.CenterCategoryListAdapter
import com.amaringo.presentation.model.Error
import org.koin.androidx.viewmodel.ext.android.getViewModel


class CenterCategoryListFragment :
    BaseFragment<CenterCategoryListViewModel, CenterListFragmentBinding>() {

    override fun getLayoutId() = R.layout.center_list_fragment

    override fun initViews() {
        addLifecyclerObserver(viewModel.centersData) {
            (dataBinding.contentList.adapter as CenterCategoryListAdapter).update(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("FRAGMENT", "CenterCategoryListFragment")
        viewModel.getCenters()
    }

    override fun setBinding() {
        viewModel = getViewModel()
        dataBinding.contentList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                VerticalSpaceItemDecoration(
                    resources.getDimension(R.dimen.category_list_divider).toInt(),
                    true
                )
            )
            adapter =
                CenterCategoryListAdapter(
                    mutableListOf(),
                    onItemSelected = { center ->
                        navigateTo(R.id.centerDetailFragment, R.id.centerListFragment, bundleOf(
                            CENTER_DATA_ARGUMENT_KEY to center)
                        )
                    },
                    onShowMoreSelected = { }
                )
        }
    }

    override fun showError(error: Error) {
        context?.let { ErrorDialog(it, error.message, {}) }
    }
}