package org.droiders.github.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by Donglua on 16/8/5.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, RetrofitModule::class))
interface ApiComponent {
//    fun inject(mainActivity: MainActivity)
}
