package com.example.tmdb.presentation.presentor.list

import androidx.paging.PositionalDataSource
import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.repository.MoviesRepository
import com.example.tmdb.executor.SchedulersProvider
import com.example.tmdb.utils.applySchedulers
import io.reactivex.Completable
import io.reactivex.Single

class PagingDataSource(
        private val moviesRepository: MoviesRepository,
        private val schedulersProvider: SchedulersProvider
) : PositionalDataSource<Movie>() {

    private var viewCallback: ViewCallback? = null

    fun setListener(viewCallback: ViewCallback) {
        this.viewCallback = viewCallback
    }

    fun removeListener() {
        this.viewCallback = null
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Movie>) {
        Single
                .fromCallable {
                    viewCallback?.onRangeLoadStart()
                    params.startPosition / params.loadSize + 1
                }
                .applySchedulers(schedulersProvider.ui(), schedulersProvider.io())
                .flatMap { moviesRepository.getMovies(it) }
                .observeOn(schedulersProvider.ui())
                .subscribe({
                    callback.onResult(it)
                    viewCallback?.onRangeLoadSuccess()
                }, {
                    viewCallback?.onRangeLoadError(it)
                })
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Movie>) {
        Completable.fromCallable { viewCallback?.onInitialLoadStart() }
                .applySchedulers(schedulersProvider.ui(), schedulersProvider.io())
                .andThen(moviesRepository.getMovies(1))
                .observeOn(schedulersProvider.ui())
                .subscribe({
                    callback.onResult(it, 0)
                    viewCallback?.onInitialLoadSuccess()
                }, {
                    viewCallback?.onInitialLoadError(it)
                })
    }

    interface ViewCallback {
        fun onInitialLoadStart()
        fun onInitialLoadSuccess()
        fun onInitialLoadError(error: Throwable)
        fun onRangeLoadStart()
        fun onRangeLoadSuccess()
        fun onRangeLoadError(error: Throwable)
    }
}