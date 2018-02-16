package jp.co.andfactory.materialgallery.presentation.common.view

import android.content.Context
import android.support.v7.app.AppCompatDialog
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout

/**
 * Created by watanabe on 2018/02/16.
 */
class ImageViewDialog(context: Context): AppCompatDialog(context) {

    val layout = LinearLayout(context).also {
        it.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        it.orientation = LinearLayout.VERTICAL
    }
    val imageView = ImageView(context).also {
        it.adjustViewBounds = true
        it.scaleType = ImageView.ScaleType.FIT_CENTER
    }

    init {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        layout.addView(imageView)
        setContentView(layout)
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        DisplayMetrics().let {
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(it)
            window.attributes = window.attributes.apply {
                width = it.widthPixels * 95 / 100
            }
        }
    }
}