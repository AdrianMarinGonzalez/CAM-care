package com.amaringo.presentation.base

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.amaringo.presentation.R
import com.amaringo.presentation.databinding.MainActivityBinding


class MainActivity: BaseActivity<MainActivityBinding>() {

    override fun getLayoutId() = R.layout.main_activity

    override fun setBinding() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }

    override fun initViews() {
        getNavHost()?.navController?.let {
            it.setGraph(it.navInflater.inflate(R.navigation.main_graph), Bundle())
        }
    }

    private fun getNavHost() = (supportFragmentManager.findFragmentById(R.id.main_navigation_container) as? NavHostFragment)
}
