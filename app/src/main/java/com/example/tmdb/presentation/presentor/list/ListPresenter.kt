package com.example.tmdb.presentation.presentor.list

import com.example.tmdb.data.model.Movie
import com.example.tmdb.domain.MoviesInteractor
import com.example.tmdb.executor.SchedulersProvider
import com.example.tmdb.presentation.view.list.MoviesView
import ru.s4nchez.mvp.BasePresenter

class ListPresenter(
        private val schedulersProvider: SchedulersProvider,
        private val moviesInteractor: MoviesInteractor,
        private val moviesPaginator: MoviesPaginator<Movie>
) : BasePresenter<MoviesView>(), MoviesPaginator.ViewController<Movie> {

    init {
        moviesPaginator.bindViewController(this)
    }

    fun refresh() {
        view?.showProgress()
        moviesPaginator.refresh()
    }

    fun loadMore() {
        view?.showProgress()
        moviesPaginator.loadNewPage()
    }

    override fun showEmptyProgress(show: Boolean) {
        view?.let {
            if (show) {
                it.showProgress()
            } else {
                it.hideProgress()
            }
        }
    }

    override fun showEmptyError(show: Boolean, error: Throwable?) {

    }

    override fun showEmptyView(show: Boolean) {

    }

    override fun showData(show: Boolean, data: List<Movie>) {
        view?.let { it.setItems(data) }
    }

    override fun showErrorMessage(error: Throwable) {

    }

    override fun showRefreshProgress(show: Boolean) {

    }

    override fun showPageProgress(show: Boolean) {
        view?.let {
            if (show) {
                it.showProgress()
            } else {
                it.hideProgress()
            }
        }
    }
}