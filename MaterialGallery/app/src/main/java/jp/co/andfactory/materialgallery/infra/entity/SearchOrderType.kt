package jp.co.andfactory.materialgallery.infra.entity

import java.util.*

/**
 * Created by watanabe on 2017/12/19.
 */
enum class SearchOrderType(val flickrSortString: String) {

    POPULAR("interestingness-desc"),
    NEW("date-posted-desc");

    override fun toString(): String {
        return super.toString().toLowerCase(Locale.US)
    }

}