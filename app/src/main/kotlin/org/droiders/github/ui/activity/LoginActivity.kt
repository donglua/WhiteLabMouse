package org.droiders.github.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import org.droiders.github.constant.Authorization.Companion.AUTHORIZATION_CALLBACK_URL
import org.droiders.github.data.oauth.OauthService
import org.droiders.github.mvp.contract.LoginContract
import org.droiders.github.ui.BaseActivity

/**
 * Created by Donglua on 16/8/17.
 */
class LoginActivity : BaseActivity(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView: WebView = WebView(this)
        setContentView(webView)

        val dataUri = intent.data
        webView.loadUrl(dataUri.toString())

        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url?.startsWith(AUTHORIZATION_CALLBACK_URL) ?: false){
                    val data = Uri.parse(url)
                    val serviceIntent: Intent = Intent(this@LoginActivity, OauthService::class.java)
                    serviceIntent.data = data
                    startService(serviceIntent)
                    finish()
                }
                return super.shouldOverrideUrlLoading(view, url)
            }
        })

    }

}