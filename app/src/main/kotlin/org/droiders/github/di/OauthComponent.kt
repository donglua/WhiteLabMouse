package org.droiders.github.di

import dagger.Component
import org.droiders.github.data.oauth.OauthService
import org.droiders.github.ui.MainActivity
import javax.inject.Singleton

/**
 * Created by donglua on 16-8-20.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, OauthModule::class))
interface OauthComponent {

  fun inject(service: OauthService)
  fun inject(activity: MainActivity)

}
