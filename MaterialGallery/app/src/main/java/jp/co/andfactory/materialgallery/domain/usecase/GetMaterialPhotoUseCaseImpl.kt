package jp.co.andfactory.materialgallery.domain.usecase

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId
import jp.co.andfactory.materialgallery.infra.repository.image_flickr.ImageFlickrRepository

/**
 * Created by watanabe on 2017/12/24.
 */
class GetMaterialPhotoUseCaseImpl(private val imageFlickrRepository: ImageFlickrRepository) : GetMaterialPhotoUseCase {

    override fun requestGet(id: MaterialPhotoId): Observable<MaterialPhoto> {
        return imageFlickrRepository.findById(id)
                .subscribeOn(Schedulers.io())
    }

}