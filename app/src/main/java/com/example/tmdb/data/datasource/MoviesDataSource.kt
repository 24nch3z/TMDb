package com.example.tmdb.data.datasource

import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Completable
import io.reactivex.Single

interface MoviesDataSource {
    fun getMovies(page: Int): Single<List<Movie>>
    fun putMovies(movies: List<Movie>): Completable
    fun clearMoviesCache(): Completable

    fun getMovieDetails(movieId: Int): Single<MovieDetails>
}