package org.droiders.github

import android.support.multidex.MultiDexApplication
import timber.log.Timber
/**
 * Created by Donglua on 16/8/3.
 */
class GithubApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}
