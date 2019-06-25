package com.example.tmdb.domain

import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Single

interface MoviesInteractor {
    fun getMovies(): Single<List<Movie>>
    fun getMovie(movieId: Int): Single<MovieDetails>
}