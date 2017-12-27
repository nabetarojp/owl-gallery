package jp.co.andfactory.materialgallery.presentation.gallery.photo

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotoUseCase
import javax.inject.Inject

class PhotoPresenter
@Inject constructor(
        val activity: Activity,
        val view: PhotoContract.View,
        val router: PhotoContract.Router,
        val useCase: GetMaterialPhotoUseCase
) : PhotoContract.Presenter {

    private val viewModel = PhotoViewModel()
    private val disposables = CompositeDisposable()

    override fun onResume() {
    }

    override fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    override fun fetchPhoto(id: MaterialPhotoId) {
        disposables.add(useCase.requestGet(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { view.showPhoto(it) },
                        onError = { view.showError("no cache") }
                ))
    }
}
