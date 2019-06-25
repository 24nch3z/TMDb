package com.example.tmdb.data.repository

import com.example.tmdb.data.datasource.DataSource
import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Single

class MoviesRepositoryImpl(private val networkDataSource: DataSource) : MoviesRepository {

    override fun getMovies(): Single<List<Movie>> {
        return networkDataSource.getMovies().map { it.results }
    }

    override fun getMovie(movieId: Int): Single<MovieDetails> {
        return networkDataSource.getMovie(movieId)
    }
}