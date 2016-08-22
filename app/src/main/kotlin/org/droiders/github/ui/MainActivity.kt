package org.droiders.github.ui

import android.content.res.Configuration
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import com.jakewharton.rxbinding.support.design.widget.RxNavigationView
import com.jakewharton.rxbinding.view.RxView
import org.droiders.github.R
import org.droiders.github.data.oauth.OauthManager
import org.droiders.github.databinding.ActivityMainBinding
import org.droiders.github.databinding.MainDrawerHeaderBinding
import org.droiders.github.di.AppModule
import org.droiders.github.di.DaggerOauthComponent
import org.droiders.github.ui.fragment.SearchFragment
import org.droiders.github.ui.fragment.TrendingFragment
import rx.android.schedulers.AndroidSchedulers.mainThread
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : BaseActivity() {
    var drawerToggle: ActionBarDrawerToggle? = null

    @Inject lateinit var oauthManager: OauthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerOauthComponent.builder().appModule(AppModule(this)).build().inject(this)

        val mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val headerBinding =
                MainDrawerHeaderBinding.inflate(layoutInflater, mainBinding.mainNavigation, false)

        mainBinding.mainNavigation.addHeaderView(headerBinding.root)
        setSupportActionBar(mainBinding.toolbar)

        drawerToggle =
                ActionBarDrawerToggle(this, mainBinding.mainDrawerLayout, mainBinding.toolbar,
                        R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mainBinding.mainDrawerLayout.addDrawerListener(drawerToggle!!)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.main_content, TrendingFragment(), TrendingFragment::class.simpleName)
                    .commitNow()
        }
        RxNavigationView.itemSelections(mainBinding.mainNavigation)
                .observeOn(mainThread())
                .subscribe({
                    mainBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                    val fragment: Fragment
                    when (it.itemId) {
                        R.id.nav_trending -> fragment = TrendingFragment()
                        R.id.nav_search -> fragment = SearchFragment()
                        else -> fragment = TrendingFragment()
                    }
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_content, fragment)
                        .commitNow()
                })
        RxView.clicks(headerBinding.buttonSignIn)
            .debounce(300, TimeUnit.MILLISECONDS)
            .observeOn(mainThread())
            .subscribe({ startActivity(oauthManager.createLoginIntent())})
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