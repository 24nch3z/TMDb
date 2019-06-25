package com.example.tmdb.data.datasource

import com.example.tmdb.data.model.Discover
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Single

interface DataSource {
    fun getMovies(): Single<Discover>
    fun getMovie(movieId: Int): Single<MovieDetails>
}