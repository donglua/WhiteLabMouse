package org.droiders.github.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import org.droiders.github.R
import org.droiders.github.databinding.ActivityMainBinding
import org.droiders.github.databinding.MainDrawerHeaderBinding

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val headerBinding =
                MainDrawerHeaderBinding.inflate(layoutInflater, mainBinding.mainNavigation, false)

        mainBinding.mainNavigation.addHeaderView(headerBinding.root)


    }

}