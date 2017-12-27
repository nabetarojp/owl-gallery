package jp.co.andfactory.materialgallery.domain.usecase

import io.reactivex.Observable
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto

/**
 * Created by watanabe on 2017/12/24.
 */
interface GetMaterialPhotosUseCase {
    fun requestGetNew(page: Int, shouldRefresh: Boolean): Observable<List<MaterialPhoto>>
    fun requestGetPopular(page: Int, shouldRefresh: Boolean): Observable<List<MaterialPhoto>>
}