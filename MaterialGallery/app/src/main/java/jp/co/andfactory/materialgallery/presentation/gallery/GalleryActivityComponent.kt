package jp.co.andfactory.materialgallery.presentation.gallery

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(GalleryActivityObjectModule::class))
interface GalleryActivityComponent : AndroidInjector<GalleryActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<GalleryActivity>() {

        abstract fun objectModule(objectModule: GalleryActivityObjectModule)

        override fun seedInstance(instance: GalleryActivity) {
            objectModule(GalleryActivityObjectModule(instance))
        }
    }
}
