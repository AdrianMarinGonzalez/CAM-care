package com.amaringo.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
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
        loadKoinModules(mainModule + getInjectionModules())
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

    }


}