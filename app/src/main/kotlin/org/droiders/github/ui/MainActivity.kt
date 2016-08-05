package org.droiders.github.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import org.droiders.github.R
import org.droiders.github.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)





    }

}