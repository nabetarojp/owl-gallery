package jp.co.andfactory.materialgallery.presentation.gallery

import android.app.Activity
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.presentation.gallery.photo.PhotoActivity
import javax.inject.Inject

class GalleryRouter
@Inject
constructor()
    : GalleryContract.Router {

    override fun openDetail(activity: Activity, photo: MaterialPhoto) {
        activity.startActivity(PhotoActivity.createIntent(activity, photo))
    }
    // add routing functions
}
