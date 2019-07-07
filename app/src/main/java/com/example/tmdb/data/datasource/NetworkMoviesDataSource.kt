package com.example.tmdb.data.datasource

import com.example.tmdb.BuildConfig
import com.example.tmdb.data.ApiInterface
import com.example.tmdb.data.common.BaseNetworkDataSource
import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.model.MovieDetails
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit

class NetworkMoviesDataSource(retrofit: Retrofit) : BaseNetworkDataSource(), MoviesDataSource {

    private val api = retrofit.create(ApiInterface::class.java)

    companion object {
        private const val LANGUAGE = "ru-RU"
        private const val SORT_BY = "popularity.desc"
    }

    override fun getMovies(page: Int): Single<List<Movie>> {
        return makeRequest(api.getMovies(BuildConfig.ApiKey, LANGUAGE, SORT_BY, page))
                .map { it.results }
    }

    override fun putMovies(movies: List<Movie>): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearMoviesCache(): Completable {
        throw UnsupportedOperationException()
    }

    override fun getMovieDetails(movieId: Int): Single<MovieDetails> {
        return makeRequest(api.getMovie(movieId, BuildConfig.ApiKey, LANGUAGE))
    }

    override fun <T> handleError(response: Response<T>): Exception {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}