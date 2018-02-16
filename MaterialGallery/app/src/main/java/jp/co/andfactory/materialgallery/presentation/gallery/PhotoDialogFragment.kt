package jp.co.andfactory.materialgallery.presentation.gallery

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import jp.co.andfactory.materialgallery.R
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId
import jp.co.andfactory.materialgallery.domain.usecase.GetMaterialPhotoUseCase
import jp.co.andfactory.materialgallery.presentation.common.view.ImageViewDialog
import jp.co.andfactory.materialgallery.util.GlideApp
import javax.inject.Inject

/**
 * Created by watanabe on 2018/02/16.
 */
class PhotoDialogFragment : DialogFragment() {

    companion object {
        private const val ARGS_PHOTO_ID = "photo_id"
        fun newInstance(id: MaterialPhotoId) = PhotoDialogFragment().also {
            it.arguments = Bundle().also {
                it.putString(ARGS_PHOTO_ID, id.value)
            }
        }
    }

    @Inject lateinit var getMaterialPhotoUseCase: GetMaterialPhotoUseCase
    private lateinit var dialog: ImageViewDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog = ImageViewDialog(activity!!)
        return dialog
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        val id = arguments?.getString(ARGS_PHOTO_ID) ?: return
        getMaterialPhotoUseCase.requestGet(MaterialPhotoId(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            GlideApp.with(activity).load(it.imageUrl).into(dialog.imageView)
                        },
                        onError = {
                            Toast.makeText(context, R.string.error_massage, Toast.LENGTH_SHORT).show()
                            dismiss()
                        }
                )
    }
}