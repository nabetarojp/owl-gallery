package jp.co.andfactory.materialgallery.infra.entity

import com.squareup.moshi.Json

/**
 * Created by watanabe on 2017/12/19.
 */
data class FlickrPhotoMeta(
        @Json(name = "page") val page: Int,
        @Json(name = "pages") val pages: Int,
        @Json(name = "perpage") val perpage: Int,
        @Json(name = "total") val total: String,
        @Json(name = "photo") val photo: List<FlickrPhoto>
)