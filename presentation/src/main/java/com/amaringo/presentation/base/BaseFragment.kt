package com.amaringo.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.amaringo.presentation.common.addLifecyclerObserver
import com.amaringo.presentation.model.ScreenFlowState
import org.koin.androidx.viewmodel.ext.android.viewModel


abstract class BaseFragment<V: BaseViewModel, T : ViewDataBinding> : Fragment() {

    protected lateinit var dataBinding: T
    protected lateinit var viewModel: V

    abstract fun injectFeatures()

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initViews()

    abstract fun setBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeatures()
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

    private fun setupObservers() {

    }


}