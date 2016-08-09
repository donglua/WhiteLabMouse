package org.droiders.github.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.view.ActionMode
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import org.droiders.github.R
import org.droiders.github.databinding.FragmentTrendingBinding
import org.droiders.github.ui.NavBaseFragment

/**
 * Created by Donglua on 16/8/7.
 */
class SearchFragment : NavBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val view = DataBindingUtil.inflate<FragmentTrendingBinding>(inflater, R.layout.fragment_trending, container, false)




        return view.root
    }

    override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
        return super.onCreateActionMode(mode, menu)
    }
}
