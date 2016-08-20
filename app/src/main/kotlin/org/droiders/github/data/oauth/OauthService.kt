package org.droiders.github.data.oauth

import android.app.IntentService
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import org.droiders.github.di.AppModule
import org.droiders.github.di.DaggerOauthComponent
import org.droiders.github.ui.MainActivity
import javax.inject.Inject

class OauthService : IntentService(OauthService::class.java.simpleName) {

  @Inject lateinit var oauthManager: OauthManager

  override fun onCreate() {
    super.onCreate()
    // Injector.obtain(getApplication()).inject(this);
    DaggerOauthComponent.builder().appModule(AppModule(this)).build().inject(this)
  }

  override fun onHandleIntent(intent: Intent) {
    oauthManager.handleResult(intent.data)

    val intent1 = Intent(this, MainActivity::class.java)
    intent1.addFlags(FLAG_ACTIVITY_NEW_TASK)
    intent1.putExtra(EXTRA_OAUTH, 1)
    startActivity(intent1)
  }

  companion object {
    val EXTRA_OAUTH = "oauth"
  }
}