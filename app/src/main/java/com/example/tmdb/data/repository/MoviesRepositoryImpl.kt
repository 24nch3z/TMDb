package com.example.tmdb.data.repository

import androidx.paging.PagedList
import com.example.tmdb.data.datasource.MoviesDataSource
import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Completable
import io.reactivex.Single

class MoviesRepositoryImpl(
        private val networkMoviesDataSource: MoviesDataSource,
        private val memoryMoviesDataSource: MoviesDataSource
) : MoviesRepository {

    private var lastPage = NO_LAST_PAGE

    companion object {
        private const val NO_LAST_PAGE = -1
    }

    override fun getMovies(page: Int): Single<List<Movie>> {
//        if (page != lastPage) {
//            return networkMoviesDataSource.getMovies(page)
//                    .flatMapCompletable { memoryMoviesDataSource.putMovies(it) }
//                    .andThen(memoryMoviesDataSource.getMovies(page))
//                    .doOnSuccess { lastPage = page }
//        }
//
//        return memoryMoviesDataSource.getMovies(page)

        return networkMoviesDataSource.getMovies(page)
    }

    override fun clearMoviesCache(): Completable {
        return memoryMoviesDataSource.clearMoviesCache()
                .doOnComplete { lastPage = NO_LAST_PAGE }
    }

    override fun getMovie(movieId: Int): Single<MovieDetails> {
        return networkMoviesDataSource.getMovieDetails(movieId)
    }
}