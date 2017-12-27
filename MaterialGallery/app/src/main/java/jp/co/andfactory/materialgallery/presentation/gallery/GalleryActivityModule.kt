package jp.co.andfactory.materialgallery.presentation.gallery

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(GalleryActivityComponent::class))
abstract class GalleryActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(GalleryActivity::class)
    abstract fun bindGalleryActivityInjectorFactory(builder: GalleryActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}
