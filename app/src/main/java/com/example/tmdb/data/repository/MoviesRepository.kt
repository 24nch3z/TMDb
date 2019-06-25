package com.example.tmdb.data.repository

import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Single

interface MoviesRepository {
    fun getMovies(): Single<List<Movie>>
    fun getMovie(movieId: Int): Single<MovieDetails>
}