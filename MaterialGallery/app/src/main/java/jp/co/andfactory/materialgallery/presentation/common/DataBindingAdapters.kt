package jp.co.andfactory.materialgallery.presentation.common

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.ImageView
import jp.co.andfactory.materialgallery.R
import jp.co.andfactory.materialgallery.util.GlideApp

/**
 * Created by watanabe on 2017/12/25.
 */

@BindingAdapter("photoImageUrl")
fun setPhotoImageUrl(imageView: ImageView, imageUrl: String?) {
    if (TextUtils.isEmpty(imageUrl)) {
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, R.color.colorPrimary_alpha_30))
    } else {
        GlideApp.with(imageView.context)
                .load(imageUrl)
                .placeholder(R.color.colorPrimary_alpha_30)
                .into(imageView)
    }
}

@BindingAdapter("photoImageUrlDontAnimate")
fun setPhotoImageUrlDontAnimate(imageView: ImageView, imageUrl: String?) {
    if (TextUtils.isEmpty(imageUrl)) {
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, R.color.colorPrimary_alpha_30))
    } else {
        GlideApp.with(imageView.context)
                .load(imageUrl)
                .placeholder(R.color.colorPrimary_alpha_30)
                .into(imageView)
    }
}