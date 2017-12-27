package jp.co.andfactory.materialgallery.domain.model

import jp.co.andfactory.materialgallery.domain.DomainModel

/**
 * Created by watanabe on 2017/12/20.
 */
data class MaterialPhoto(
        override val id: MaterialPhotoId,
        val title: String,
        val imageUrl: String
) : DomainModel<MaterialPhotoId>()