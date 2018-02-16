package jp.co.andfactory.materialgallery.domain.usecase

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.infra.entity.SearchOrderType
import jp.co.andfactory.materialgallery.infra.repository.ImageFlickrRepository

/**
 * Created by watanabe on 2017/12/24.
 */
class GetMaterialPhotosUseCaseImpl(private val imageFlickrRepository: ImageFlickrRepository) : GetMaterialPhotosUseCase {


    companion object {
        private const val SEARCH_TEXT = "Owl"
        private const val PER_PAGE = 32
    }

    override fun requestGetNew(page: Int, shouldRefresh: Boolean): Observable<List<MaterialPhoto>> {
        return requestGet(page, shouldRefresh, SearchOrderType.NEW)
    }

    override fun requestGetPopular(page: Int, shouldRefresh: Boolean): Observable<List<MaterialPhoto>> {
        return requestGet(page, shouldRefresh, SearchOrderType.POPULAR)
    }

    private fun requestGet(page: Int, shouldRefresh: Boolean, searchOrderType: SearchOrderType): Observable<List<MaterialPhoto>> {
        val single: Single<Int> = if (shouldRefresh) imageFlickrRepository.clearCache(searchOrderType, SEARCH_TEXT) else Single.just(1)

        return single.toObservable()
                .flatMap { imageFlickrRepository.findByText(searchOrderType, SEARCH_TEXT, page, PER_PAGE) }
                .subscribeOn(Schedulers.io())
    }

}