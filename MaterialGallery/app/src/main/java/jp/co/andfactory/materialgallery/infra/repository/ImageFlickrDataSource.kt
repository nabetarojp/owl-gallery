package jp.co.andfactory.materialgallery.infra.repository

import io.reactivex.Observable
import io.reactivex.Single
import jp.co.andfactory.materialgallery.infra.entity.FlickrPhoto
import jp.co.andfactory.materialgallery.infra.entity.SearchOrderType

/**
 * Created by watanabe on 2017/12/19.
 */
interface ImageFlickrDataSource{

    fun findByText(searchOrderType: SearchOrderType, text: String, page: Int, perPage: Int): Observable<List<FlickrPhoto>>

    fun findById(id: String): Observable<FlickrPhoto> = Observable.empty()

    fun updateCache(searchOrderType: SearchOrderType, text: String, page: Int, photos: List<FlickrPhoto>) = Any()

    fun clearCache(searchOrderType: SearchOrderType, text: String): Single<Int> = Single.never()
}