@file:JvmName("BindingUtils")

package org.droiders.github.ui

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.droiders.github.R

/**
 * 自定义DataBinding属性
 * Created by Donglua on 16/8/7.
 */
@BindingAdapter("imageUrl")
fun loadAvatarImage(imageView: ImageView?, url: String?) {
    imageView ?: url ?: Glide.with(imageView?.context)
            .load(url)
            .placeholder(R.drawable.avatar)
            .dontAnimate()
            .into(imageView)
}