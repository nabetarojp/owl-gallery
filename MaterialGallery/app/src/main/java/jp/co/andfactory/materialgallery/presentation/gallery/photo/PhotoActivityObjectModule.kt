package jp.co.andfactory.materialgallery.presentation.gallery.photo

import android.app.Activity
import dagger.Module
import dagger.Provides
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotoUseCase

@Module
class PhotoActivityObjectModule(val view: PhotoContract.View) {
    @Provides
    fun providePresenter(router: PhotoRouter, useCase: GetMaterialPhotoUseCase): PhotoContract.Presenter {
        return PhotoPresenter(view as Activity, view, router, useCase)
    }
}
