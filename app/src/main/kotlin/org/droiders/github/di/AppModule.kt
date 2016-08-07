package org.droiders.github.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Donglua on 16/8/4.
 */
@Module
class AppModule(val context: Context) {

    @Provides @Singleton
    fun provideContext() : Context {
        return context
    }
}
