package jp.co.andfactory.materialgallery.presentation.gallery

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.widget.ImageView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotosUseCase
import javax.inject.Inject

class GalleryPresenter
@Inject constructor(
        private val activity: Activity,
        private val view: GalleryContract.View,
        private val router: GalleryContract.Router,
        private val getMaterialPhotosUseCase: GetMaterialPhotosUseCase
) : GalleryContract.Presenter {

    private val disposals = CompositeDisposable()
    private val viewModel = GalleryViewModel()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {}

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        if (!disposals.isDisposed) {
            disposals.dispose()
        }
    }

    override fun fetchPhotos(isRefresh: Boolean) {
        if (!viewModel.isLoading) {
            viewModel.isLoading = true
            if (isRefresh) {
                viewModel.page = 0
            }
            view.showProgress()
            disposals.add(getMaterialPhotosUseCase.requestGetPopular(++viewModel.page, false)
                    .subscribeBy(
                            onNext = {
                                view.hideProgress()
                                view.showPhotos(it, isRefresh)
                                viewModel.isLoading = false
                            },
                            onError = {
                                view.hideProgress()
                                viewModel.isLoading = false
                            }
                    ))
        }
    }

    override fun onClickItem(view: ImageView, photo: MaterialPhoto) {
        router.openDetail(activity, view, photo)
    }
}
