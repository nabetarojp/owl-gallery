package jp.co.andfactory.materialgallery.presentation.gallery

import android.app.Activity
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.widget.ImageView
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.presentation.gallery.photo.PhotoActivity
import javax.inject.Inject

class GalleryRouter
@Inject
constructor()
    : GalleryContract.Router {

    override fun openDetail(activity: Activity, view: ImageView, photo: MaterialPhoto) {
        val b = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, ViewCompat.getTransitionName(view)).toBundle()
        ActivityCompat.startActivity(activity, PhotoActivity.createIntent(activity, photo), b)
    }
    // add routing functions
}
