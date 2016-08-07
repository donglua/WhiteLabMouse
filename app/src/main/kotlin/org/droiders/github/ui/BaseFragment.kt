package org.droiders.github.ui

import android.support.v4.app.Fragment
import android.support.v7.view.ActionMode
import android.view.Menu
import android.view.MenuItem

/**
 * Created by Donglua on 16/8/7.
 */
open class BaseFragment : Fragment(), ActionMode.Callback {

    override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
        return false
    }

    override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
        return false
    }

    override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
        return false
    }

    override fun onDestroyActionMode(mode: ActionMode) {
    }
}
