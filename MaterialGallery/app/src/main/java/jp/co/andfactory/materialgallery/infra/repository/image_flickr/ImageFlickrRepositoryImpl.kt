package jp.co.andfactory.materialgallery.infra.repository.image_flickr

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId
import jp.co.andfactory.materialgallery.infra.entity.FlickrPhoto
import jp.co.andfactory.materialgallery.infra.entity.SearchOrderType
import jp.co.andfactory.materialgallery.infra.entity.mapper.MaterialImageMapper

/**
 * Created by watanabe on 2017/12/23.
 */

class ImageFlickrRepositoryImpl(
        private val remote: ImageFlickrDataSource,
        private val local: ImageFlickrDataSource
) : ImageFlickrRepository {

    override fun findByText(searchOrderType: SearchOrderType, text: String, page: Int, perPage: Int): Observable<List<MaterialPhoto>> {
        return remote.findByText(searchOrderType, text, page, perPage)
                .observeOn(Schedulers.newThread())
                .doOnNext { p: List<FlickrPhoto> -> local.updateCache(searchOrderType, text, page, p) }
                .filter{ photos -> !photos.isEmpty()}
                .first(ArrayList())
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .map { MaterialImageMapper.transform(it) }
    }

    override fun findById(materialPhotoId: MaterialPhotoId): Observable<MaterialPhoto> {
        return local.findById(materialPhotoId.value)
                .observeOn(AndroidSchedulers.mainThread())
                .map { MaterialImageMapper.transform(it) }
    }

    override fun clearCache(searchOrderType: SearchOrderType, text: String): Single<Int> {
        return local.clearCache(searchOrderType, text)
                .observeOn(Schedulers.newThread())
    }


}