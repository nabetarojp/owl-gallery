package jp.co.andfactory.materialgallery.domain.usecase

import io.reactivex.Observable
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId

/**
 * Created by watanabe on 2017/12/20.
 */

interface GetMaterialPhotoUseCase {
    fun requestGet(id: MaterialPhotoId): Observable<MaterialPhoto>
}
