package jp.co.andfactory.materialgallery.presentation.gallery.photo

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(PhotoActivityComponent::class))
abstract class PhotoActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(PhotoActivity::class)
    abstract fun bindPhotoActivityInjectorFactory(builder: PhotoActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}
