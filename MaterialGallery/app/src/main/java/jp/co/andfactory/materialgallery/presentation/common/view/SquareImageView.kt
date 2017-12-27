package jp.co.andfactory.materialgallery.presentation.common.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by watanabe on 2017/12/25.
 */
class SquareImageView : ImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}