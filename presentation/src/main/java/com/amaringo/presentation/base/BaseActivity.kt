package com.amaringo.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var dataBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
    }

    private fun bindView() {
        DataBindingUtil.setContentView<T>(this, getLayoutId()).also {
            dataBinding = it
            setBinding()
            dataBinding.executePendingBindings()
            dataBinding.lifecycleOwner = this
            initViews()
        }
    }

    @LayoutRes abstract fun getLayoutId(): Int

    abstract fun initViews()

    abstract fun setBinding()
}