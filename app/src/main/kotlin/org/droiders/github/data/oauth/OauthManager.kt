package org.droiders.github.data.oauth

import android.content.Intent
import android.net.Uri
import com.f2prateek.rx.preferences.Preference
import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.droiders.github.constant.Authorization
import org.droiders.github.data.IntentFactory
import org.droiders.github.di.Scope.AccessToken
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

/**
 * 参考: https://github.com/JakeWharton/u2020/blob/master/src/main/java/com/jakewharton/u2020/data/api/oauth/OauthManager.java
 */
class OauthManager @Inject constructor(val intentFactory: IntentFactory,
    val client: OkHttpClient,
    val gson: Gson,
    @AccessToken val accessToken: Preference<String>) {

  fun createLoginIntent(): Intent {
    val authorizeUrl = HttpUrl.parse("https://github.com/login/oauth/authorize") //
        .newBuilder() //
        .addQueryParameter("client_id", Authorization.CLIENT_ID) //
        .build()

    return intentFactory.createUrlIntent(authorizeUrl.toString())
  }

  fun handleResult(data: Uri?) {
    val code = data?.getQueryParameter("code") ?: return

    Timber.d("code = %s", code)

    try {
      // Trade our code for an access token.
      val request = Request.Builder() //
          .url("https://github.com/login/oauth/access_token") //
          .header("Accept", "application/json") //
          .post(FormBody.Builder() //
              .add("client_id", Authorization.CLIENT_ID) //
              .add("client_secret", Authorization.CLIENT_SECRET) //
              .add("code", code) //
              .build()) //
          .build()

      val response = client.newCall(request).execute()
      if (response.isSuccessful) {
        val accessTokenResponse = gson.fromJson(response.body().string(),
            AccessTokenResponse::class.java)
        if (accessTokenResponse != null && accessTokenResponse.access_token != null) {
          accessToken.set(accessTokenResponse.access_token)
        }
      }
    } catch (e: IOException) {
      Timber.w(e, "Failed to get access token.")
    }

  }

  private class AccessTokenResponse private constructor(val access_token: String?, scope: String)

}