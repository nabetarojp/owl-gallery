package jp.co.andfactory.materialgallery.infra.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import jp.co.andfactory.materialgallery.infra.api.FlickrApiService
import jp.co.andfactory.materialgallery.infra.entity.FlickrPhoto
import jp.co.andfactory.materialgallery.infra.entity.SearchOrderType

/**
 * Created by watanabe on 2017/12/19.
 */
class ImageFlickrRemoteDataSource(private val flickrApiService: FlickrApiService) : ImageFlickrDataSource{

    override fun findByText(searchOrderType: SearchOrderType, text: String, page: Int, perPage: Int): Observable<List<FlickrPhoto>> {
        return flickrApiService.photoSearch(text, page, perPage, searchOrderType.flickrSortString)
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.photos.photo }
    }

}