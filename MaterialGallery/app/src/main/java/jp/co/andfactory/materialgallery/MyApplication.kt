package jp.co.andfactory.materialgallery

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import jp.co.andfactory.materialgallery._di.DaggerAppComponent


/**
 * Created by watanabe on 2017/12/24.
 */
class MyApplication : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }


}