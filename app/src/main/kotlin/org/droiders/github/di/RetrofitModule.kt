package org.droiders.github.di

import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import org.droiders.github.data.GithubService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers.io
import javax.inject.Singleton

/**
 * Created by Donglua on 16/8/16.
 */
@Module
class RetrofitModule {

    @Provides @Singleton
    fun provideBaseUrl(): HttpUrl = HttpUrl.parse("https://api.github.com/")

    @Provides @Singleton fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides @Singleton fun provideRetrofit(baseUrl: HttpUrl, okhttp: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okhttp)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(io()))
                .build()
    }

    @Provides @Singleton fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

}