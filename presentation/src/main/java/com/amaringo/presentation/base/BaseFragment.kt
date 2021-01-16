package com.amaringo.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.amaringo.presentation.R
import com.amaringo.presentation.common.addLifecyclerObserver
import com.amaringo.presentation.model.Error


abstract class BaseFragment<V: BaseViewModel, T : ViewDataBinding> : Fragment() {

    protected lateinit var dataBinding: T
    protected lateinit var viewModel: V

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initViews()

    abstract fun setBinding()

    abstract fun showError(error: Error)

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
        addLifecyclerObserver(viewModel.error) {
            showError(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    protected fun navigateTo(@IdRes destination: Int, @IdRes popUpTo: Int, args: Bundle) {
        val options = NavOptions.Builder().apply {
            setEnterAnim(R.anim.slide_in_right)
            setExitAnim(R.anim.slide_out_left)
            setPopEnterAnim(R.anim.slide_in_left)
            setPopExitAnim(R.anim.slide_out_right)
            setPopUpTo(popUpTo, false)
        }.build()
        findNavController().navigate(destination, args, options)

    }

    protected fun navigateBack(){
        findNavController().popBackStack()
    }
}