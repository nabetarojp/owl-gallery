package jp.co.andfactory.materialgallery._extension

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding

/**
 * Created by watanabe on 2017/12/24.
 */
fun <T: ViewDataBinding> Activity.contentViewBinding(layout: Int): Lazy<T> = lazy {
    DataBindingUtil.setContentView<T>(this, layout)
}
