package org.droiders.github.ui.activity

import android.os.Bundle
import android.webkit.WebView
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


    }

}