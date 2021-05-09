package com.huawei.mymovieapplication.presentation.di

import com.huawei.mymovieapplication.data.api.TMDBService
import com.huawei.mymovieapplication.data.repository.movie.datasource.MovieRemoteDatasource
import com.huawei.mymovieapplication.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDatasource{
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}