package com.amaringo.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.amaringo.presentation.R
import com.amaringo.presentation.common.CENTER_DATA_ARGUMENT_KEY
import com.amaringo.presentation.common.addLifecyclerObserver
import com.amaringo.presentation.model.ScreenFlowState
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module


abstract class BaseFragment<V: BaseViewModel, T : ViewDataBinding> : Fragment() {

    protected lateinit var dataBinding: T
    protected lateinit var viewModel: V

    abstract fun getInjectionModules(): List<Module>

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initViews()

    abstract fun setBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(presentationModule + getInjectionModules())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false).also {
            dataBinding = it
            setBinding()
            dataBinding.executePendingBindings()
            dataBinding.lifecycleOwner = this
            initViews()
            setupObservers()
        }.root

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun setupObservers() {
        addLifecyclerObserver(viewModel.screenState) {
            when(it) {
                is ScreenFlowState.NavigateToCenterDetail -> {
                    val arguments = bundleOf(CENTER_DATA_ARGUMENT_KEY to it.data)
                    findNavController().navigate(R.id.centerDetailFragment)
}
            }
        }
    }


}