package org.droiders.github.constant

import org.droiders.github.BuildConfig

/**
 * Created by donglua on 16-8-19.
 */
class Authorization {
  companion object {
    val AUTHORIZE_URL = "https://github.com/login/oauth/authorize"

    val CLIENT_ID = BuildConfig.CLIENT_ID
    val CLIENT_SECRET = BuildConfig.CLIENT_SECRET
    val AUTHORIZATION_CALLBACK_URL = BuildConfig.GITHUB_CALLBACK_URL

    val AUTHORIZE_URL_PARAMS = AUTHORIZE_URL +
        "?" + "client_id=" + CLIENT_ID +
        "&" + "redirect_uri=" + AUTHORIZATION_CALLBACK_URL +
        "&" + "scope=" + "repo, user"
  }
}