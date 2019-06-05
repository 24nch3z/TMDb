package com.example.tmdb.di

import android.content.Context
import com.example.tmdb.data.ApiInterface
import com.example.tmdb.data.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(context: Context): Retrofit {
        val cacheSize: Long = 10 * 1024 * 1024 // 10MB
        val cache = Cache(context.cacheDir, cacheSize)

        val okHttpClient = OkHttpClient.Builder()
//                .cache(cache)
                .build()

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideAPIInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}