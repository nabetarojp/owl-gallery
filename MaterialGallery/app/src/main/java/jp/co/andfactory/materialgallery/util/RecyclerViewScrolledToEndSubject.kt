package jp.co.andfactory.materialgallery.util

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.reactivex.subjects.PublishSubject

/**
 * Created by watanabe on 2017/12/24.
 */
class RecyclerViewScrolledToEndSubject(private val recyclerView: RecyclerView) {

    private val subject = PublishSubject.create<Unit>()

    private val listener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val manager = (recyclerView.layoutManager as LinearLayoutManager)
            val visibleCount = recyclerView.childCount
            val totalCount = manager.itemCount
            val firstPos = manager.findFirstVisibleItemPosition()
            if (totalCount - visibleCount <= firstPos) {
                subject.onNext(Unit)
            }
        }
    }

    init {
        if (recyclerView.layoutManager !is LinearLayoutManager) {
            throw IllegalArgumentException("needs to have LinearLayoutManager")
        }
        recyclerView.addOnScrollListener(listener)
    }

    fun connetion() = subject

    fun shutDown() {
        recyclerView.removeOnScrollListener(listener)
    }
}