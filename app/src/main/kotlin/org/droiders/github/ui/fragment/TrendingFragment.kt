package org.droiders.github.ui.fragment

import android.os.Bundle
import android.support.v7.view.ActionMode
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import org.droiders.github.databinding.FragmentTrendingBinding
import org.droiders.github.ui.BaseFragment

/**
 * Created by Donglua on 16/8/7.
 */
class TrendingFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = FragmentTrendingBinding.inflate(inflater, container, false)




        return view.root
    }

    override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
        return super.onCreateActionMode(mode, menu)
    }
}
