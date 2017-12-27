package jp.co.andfactory.materialgallery.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.module.AppGlideModule

/**
 * Created by watanabe on 2017/12/25.
 */
@GlideModule
class MyGlideModule :AppGlideModule() {

    override fun applyOptions(context: Context?, builder: GlideBuilder) {
        builder.setDefaultTransitionOptions(Drawable::class.java, DrawableTransitionOptions.withCrossFade())
                .setDefaultTransitionOptions(Bitmap::class.java, BitmapTransitionOptions.withCrossFade())
    }
}