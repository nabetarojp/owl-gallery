package jp.co.andfactory.materialgallery.presentation.gallery.photo

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(PhotoActivityObjectModule::class))
interface PhotoActivityComponent : AndroidInjector<PhotoActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<PhotoActivity>() {

        abstract fun objectModule(objectModule: PhotoActivityObjectModule)

        override fun seedInstance(instance: PhotoActivity) {
            objectModule(PhotoActivityObjectModule(instance))
        }
    }
}
