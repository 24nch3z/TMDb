package com.example.tmdb.presentation.presentor.list

import androidx.paging.PagedList
import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.repository.PagingDataSource
import com.example.tmdb.presentation.view.list.MoviesView
import ru.s4nchez.mvp.BasePresenter

class ListPresenter(
        private val pagedList: PagedList<Movie>,
        private val pagingDataSource: PagingDataSource
) : BasePresenter<MoviesView>(), PagingDataSource.ViewCallback {

    init {
        pagingDataSource.setListener(this)
    }

    fun init() {
        view?.setPagedList(pagedList)
    }

    override fun removeView() {
        pagingDataSource.removeListener()
        super.removeView()
    }

    override fun onInitialLoadStart() {
        view?.showProgress()
    }

    override fun onInitialLoadSuccess() {
        view?.hideProgress()
    }

    override fun onInitialLoadError(error: Throwable) {
        view?.hideProgress()
    }

    override fun onRangeLoadStart() {
        view?.showProgress()
    }

    override fun onRangeLoadSuccess() {
        view?.hideProgress()
    }

    override fun onRangeLoadError(error: Throwable) {
        view?.hideProgress()
    }
}