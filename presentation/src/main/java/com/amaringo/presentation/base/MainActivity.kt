package com.amaringo.presentation.base

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.amaringo.presentation.R
import com.amaringo.presentation.databinding.MainActivityBinding


class MainActivity: BaseActivity<MainActivityBinding>() {

    override fun getLayoutId() = R.layout.main_activity

    override fun setBinding() {

    }

    override fun initViews() {
        getNavHost()?.navController?.apply {
            setGraph(navInflater.inflate(R.navigation.main_graph), Bundle())
        }
    }

    private fun getNavHost() = (supportFragmentManager.findFragmentById(R.id.main_navigation_container) as? NavHostFragment)
}
