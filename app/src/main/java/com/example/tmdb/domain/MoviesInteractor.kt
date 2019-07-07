package com.example.tmdb.domain

import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Completable
import io.reactivex.Single

interface MoviesInteractor {
    fun getMovies(page: Int): Single<List<Movie>>
    fun clearMoviesCache(): Completable
    fun getMovie(movieId: Int): Single<MovieDetails>
}