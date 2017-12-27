package jp.co.andfactory.materialgallery.domain

/**
 * Created by watanabe on 2017/12/19.
 */
open class Identifier<out T>(val value: T) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Identifier<*>) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }
}