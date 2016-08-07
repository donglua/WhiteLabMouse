package org.droiders.github.di

import dagger.Component
import org.droiders.github.ui.MainActivity
import javax.inject.Singleton

/**
 * Created by Donglua on 16/8/5.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface ApiComponent {
    fun inject(mainActivity: MainActivity)
}
