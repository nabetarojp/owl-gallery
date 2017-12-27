package jp.co.andfactory.materialgallery._di

import dagger.Module
import dagger.Provides
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotoUseCase
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotoUseCaseImpl
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotosUseCase
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotosUseCaseImpl
import jp.co.andfactory.materialgallery.infra.repository.ImageFlickrRepository

/**
 * Created by watanabe on 2017/12/24.
 */
@Module
class UseCaseModule {

    @Provides
    fun provideGetMaterialPhotosUseCase(
            imageFlickrRepository: ImageFlickrRepository
    ): GetMaterialPhotosUseCase = GetMaterialPhotosUseCaseImpl(imageFlickrRepository)

    @Provides
    fun provideGetMaterialPhotoUseCase(
            imageFlickrRepository: ImageFlickrRepository
    ): GetMaterialPhotoUseCase = GetMaterialPhotoUseCaseImpl(imageFlickrRepository)
}