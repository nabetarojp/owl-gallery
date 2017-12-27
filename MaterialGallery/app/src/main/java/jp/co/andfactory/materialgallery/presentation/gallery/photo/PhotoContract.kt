package jp.co.andfactory.materialgallery.presentation.gallery.photo

import android.arch.lifecycle.LifecycleObserver
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId

interface PhotoContract {

    interface View {
        fun showPhoto(photo: MaterialPhoto)
        fun showError(message: String)
    }

    interface Presenter : LifecycleObserver {
        fun onResume() // base
        fun onPause()  // base
        fun onDestroy()

        fun fetchPhoto(id: MaterialPhotoId)
    }

    interface Router {

    }
}
