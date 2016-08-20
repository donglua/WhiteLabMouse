package org.droiders.github.di

import android.content.Context
import android.content.SharedPreferences
import com.f2prateek.rx.preferences.Preference
import com.f2prateek.rx.preferences.RxSharedPreferences
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.droiders.github.data.InstantDeserializer
import org.droiders.github.data.IntentFactory
import org.droiders.github.di.Scope.AccessToken
import org.threeten.bp.Instant
import timber.log.Timber
import javax.inject.Singleton

/**
 * Created by donglua on 16-8-20.
 */
@Module
class OauthModule {

  @Provides @Singleton fun provideSharedPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences("Github", Context.MODE_PRIVATE)
  }

  @Provides @Singleton fun provideRxSharedPreferences(prefs: SharedPreferences): RxSharedPreferences {
    return RxSharedPreferences.create(prefs)
  }

  @Provides @Singleton @AccessToken fun provideAccessToken(prefs: RxSharedPreferences): Preference<String> {
    return prefs.getString("access-token")
  }

  @Provides @Singleton fun provideIntentFactory(): IntentFactory {
    return IntentFactory.REAL
  }

  @Provides @Singleton fun provideOkHttpClient(// context: Application,
      loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
  }

  @Provides @Singleton fun provideGson(): Gson {
    return GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .registerTypeAdapter(Instant::class.java, InstantDeserializer())
        .create()
  }

  @Provides @Singleton fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").v(message) }
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
  }

}