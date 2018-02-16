package jp.co.andfactory.materialgallery.presentation.gallery

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class PhotoDialogFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributePhotoDialogFramgnet(): PhotoDialogFragment
}
