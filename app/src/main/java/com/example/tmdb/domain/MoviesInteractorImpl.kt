package com.example.tmdb.domain

import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import com.example.tmdb.data.repository.MoviesRepository
import com.example.tmdb.executor.SchedulersProvider
import io.reactivex.Single

class MoviesInteractorImpl(
        private val schedulersProvider: SchedulersProvider,
        private val repository: MoviesRepository
) : MoviesInteractor {

    override fun getMovies(): Single<List<Movie>> {
        return repository.getMovies().subscribeOn(schedulersProvider.io())
    }

    override fun getMovie(movieId: Int): Single<MovieDetails> {
        return repository.getMovie(movieId).subscribeOn(schedulersProvider.io())
    }
}