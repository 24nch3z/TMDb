package com.example.tmdb.data.datasource

import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.NullPointerException

class MemoryMoviesDataSource : MoviesDataSource {

    private var movies = ArrayList<Movie>()

    override fun getMovies(page: Int): Single<List<Movie>> {
        return Single.create {
            if (movies.isNotEmpty()) {
                it.onSuccess(movies)
            } else {
                it.onError(NullPointerException())
            }
        }
    }

    override fun putMovies(movies: List<Movie>): Completable {
        return Completable.fromAction { this.movies.addAll(movies) }
    }

    override fun clearMoviesCache(): Completable {
        return Completable.fromAction { this.movies.clear() }
    }

    override fun getMovieDetails(movieId: Int): Single<MovieDetails> {
        throw UnsupportedOperationException()
    }
}