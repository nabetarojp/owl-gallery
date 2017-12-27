package jp.co.andfactory.materialgallery._di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by watanabe on 2017/12/19.
 */

@Module
class AppModule(private val application: Application) {


    @Provides
    fun provideApplication() = application

    @Provides
    fun provideContext(): Context = application


}