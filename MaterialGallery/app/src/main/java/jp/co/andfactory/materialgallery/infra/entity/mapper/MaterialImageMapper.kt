package jp.co.andfactory.materialgallery.infra.entity.mapper

import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto
import jp.co.andfactory.materialgallery.domain.model.MaterialPhotoId
import jp.co.andfactory.materialgallery.infra.entity.FlickrPhoto
import jp.co.andfactory.materialgallery.infra.entity.FlickrPhotoResponse

/**
 * Created by watanabe on 2017/12/20.
 */

object MaterialImageMapper {

    fun transform(photo: FlickrPhoto): MaterialPhoto = MaterialPhoto(
            id = MaterialPhotoId(photo.id),
            imageUrl = "http://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg",
            title = photo.title
    )

    fun transform(photos: List<FlickrPhoto>): MutableList<MaterialPhoto> = mutableListOf<MaterialPhoto>().apply {
        addAll(photos.map { transform(it) })
    }

    fun transform(response: FlickrPhotoResponse): MutableList<MaterialPhoto> = transform(response.photos.photo)
}