package org.droiders.github.data

import android.content.Intent
import android.net.Uri

interface IntentFactory {
  fun createUrlIntent(url: String): Intent

  companion object {

    val REAL: IntentFactory = object : IntentFactory {
      override fun createUrlIntent(url: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addCategory("__github_mouse")
        return intent
      }
    }
  }
} 