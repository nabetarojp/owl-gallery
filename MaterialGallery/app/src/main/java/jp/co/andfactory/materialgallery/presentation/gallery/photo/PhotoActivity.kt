package jp.co.andfactory.materialgallery.presentation.gallery.photo

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import jp.co.andfactory.materialgallery.R
import jp.co.andfactory.materialgallery._extension.contentViewBinding
import jp.co.andfactory.materialgallery.databinding.ActivityPhotoBinding
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId
import javax.inject.Inject

class PhotoActivity : AppCompatActivity(), PhotoContract.View, LifecycleOwner {

    companion object {
        private const val EXTRA_PHOTO_ID: String = "photo_id"

        fun createIntent(context: Context, photo: MaterialPhoto): Intent {
            return Intent(context, PhotoActivity::class.java).apply {
                putExtra(EXTRA_PHOTO_ID, photo.id.value)
            }
        }
    }

    @Inject
    lateinit var presenter: PhotoContract.Presenter

    val binding: ActivityPhotoBinding by contentViewBinding(R.layout.activity_photo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        lifecycle.addObserver(presenter)
        supportPostponeEnterTransition()
        presenter.fetchPhoto(MaterialPhotoId(intent.extras.getString(EXTRA_PHOTO_ID)))
    }

    override fun showPhoto(photo: MaterialPhoto) {
        binding.photo = photo
    }

    override fun showError(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE).show()
    }
}
