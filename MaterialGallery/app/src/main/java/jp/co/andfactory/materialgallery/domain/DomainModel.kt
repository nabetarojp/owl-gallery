package jp.co.andfactory.materialgallery.domain

/**
 * Created by watanabe on 2017/12/20.
 */
abstract class DomainModel<out T: Identifier<*>> {

    abstract val id: T

    override fun equals(other: Any?): Boolean {
        if (other is DomainModel<*>) return other.id == id

        return false
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}