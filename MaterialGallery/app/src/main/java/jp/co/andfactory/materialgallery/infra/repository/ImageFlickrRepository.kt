package jp.co.andfactory.materialgallery.infra.repository

import io.reactivex.Observable
import io.reactivex.Single
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId
import jp.co.andfactory.materialgallery.infra.entity.SearchOrderType

/**
 * Created by watanabe on 2017/12/19.
 */
interface ImageFlickrRepository {

    fun findByText(searchOrderType: SearchOrderType, text: String, page: Int, perPage: Int): Observable<List<MaterialPhoto>>

    fun findById(materialPhotoId: MaterialPhotoId): Observable<MaterialPhoto>

    fun clearCache(searchOrderType: SearchOrderType, text: String): Single<Int>

}