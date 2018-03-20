package jp.co.andfactory.materialgallery.infra.repository.image_flickr

import com.github.gfx.android.orma.annotation.OnConflict
import io.reactivex.Observable
import io.reactivex.Single
import jp.co.andfactory.materialgallery.infra.entity.FlickrPhoto
import jp.co.andfactory.materialgallery.infra.entity.OrmaDatabase
import jp.co.andfactory.materialgallery.infra.entity.SearchOrderType

/**
 * Created by watanabe on 2017/12/19.
 */
class ImageFlickrLocalDataSource(private val orma: OrmaDatabase) : ImageFlickrDataSource {


    override fun findByText(searchOrderType: SearchOrderType, text: String, page: Int, perPage: Int): Observable<List<FlickrPhoto>> {
        return orma.selectFromFlickrPhoto()
                .typeEq(searchOrderType.toString())
                .limit(perPage.toLong())
                .offset(((page - 1) * perPage).toLong())
                .executeAsObservable()
                .toList()
                .toObservable()
    }

    override fun findById(id: String): Observable<FlickrPhoto> {
        return orma.selectFromFlickrPhoto()
                .idEq(id)
                .executeAsObservable()
    }

    override fun updateCache(searchOrderType: SearchOrderType, text: String, page: Int, photos: List<FlickrPhoto>) {
        orma.prepareInsertIntoFlickrPhoto(OnConflict.REPLACE)
                .executeAll(
                        photos.map {
                            it.apply {
                                type = searchOrderType.toString()
                                searchedText = text
                            }
                        }
                )
    }

    override fun clearCache(searchOrderType: SearchOrderType, text: String): Single<Int> {
        return orma.deleteFromFlickrPhoto()
                .typeEq(searchOrderType.toString())
                .searchedTextEq(text)
                .executeAsSingle()
    }

}