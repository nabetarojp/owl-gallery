package jp.co.andfactory.materialgallery.presentation.gallery

import android.app.Activity
import dagger.Module
import dagger.Provides
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotosUseCase

@Module
class GalleryActivityObjectModule(val view: GalleryContract.View) {


    @Provides
    fun providePresenter(router: GalleryRouter, getMaterialPhotosUseCase: GetMaterialPhotosUseCase): GalleryContract.Presenter {
        return GalleryPresenter(view as Activity, view, router, getMaterialPhotosUseCase)
    }
}
