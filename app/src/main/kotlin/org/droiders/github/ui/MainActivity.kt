package org.droiders.github.ui

import android.content.res.Configuration
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import com.jakewharton.rxbinding.support.design.widget.RxNavigationView
import org.droiders.github.R
import org.droiders.github.databinding.ActivityMainBinding
import org.droiders.github.databinding.MainDrawerHeaderBinding
import org.droiders.github.ui.fragment.SearchFragment
import org.droiders.github.ui.fragment.TrendingFragment
import rx.android.schedulers.AndroidSchedulers

class MainActivity : BaseActivity() {
    var drawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val headerBinding =
                MainDrawerHeaderBinding.inflate(layoutInflater, mainBinding.mainNavigation, false)

        mainBinding.mainNavigation.addHeaderView(headerBinding.root)
        setSupportActionBar(mainBinding.toolbar)

        drawerToggle =
                ActionBarDrawerToggle(this, mainBinding.mainDrawerLayout, mainBinding.toolbar,
                        R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mainBinding.mainDrawerLayout.addDrawerListener(drawerToggle!!)

        supportFragmentManager.beginTransaction().add(R.id.main_content, TrendingFragment()).commit()
        RxNavigationView.itemSelections(mainBinding.mainNavigation)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mainBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                    val fragment: NavBaseFragment
                    when (it.itemId) {
                        R.id.nav_trending -> fragment = TrendingFragment()
                        R.id.nav_search -> fragment = SearchFragment()
                        else -> fragment = TrendingFragment()
                    }
                    supportFragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit()
                })
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle?.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle?.onConfigurationChanged(newConfig)
    }

}