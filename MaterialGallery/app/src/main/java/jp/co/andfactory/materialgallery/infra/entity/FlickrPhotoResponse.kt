package jp.co.andfactory.materialgallery.infra.entity

import com.squareup.moshi.Json

/**
 * Created by watanabe on 2017/12/19.
 */
data class FlickrPhotoResponse(
        @Json(name = "photos") val photos: FlickrPhotoMeta,
        @Json(name = "stat") val stat: String
)