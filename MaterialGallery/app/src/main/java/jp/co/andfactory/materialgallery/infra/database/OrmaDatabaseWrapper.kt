package jp.co.andfactory.materialgallery.infra.database

import android.content.Context
import jp.co.andfactory.materialgallery.infra.entity.OrmaDatabase

/**
 * Created by watanabe on 2017/12/21.
 */
class OrmaDatabaseWrapper(context: Context) {
    val orma: OrmaDatabase = OrmaDatabase.builder(context).build()
}