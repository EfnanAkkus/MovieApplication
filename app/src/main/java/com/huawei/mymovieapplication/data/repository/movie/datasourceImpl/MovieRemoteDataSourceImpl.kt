package com.huawei.mymovieapplication.data.repository.movie.datasourceImpl

import com.huawei.mymovieapplication.data.api.TMDBService
import com.huawei.mymovieapplication.data.model.movie.MovieList
import com.huawei.mymovieapplication.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

//this class will need an instance of TMDBService, TMDBService is a dependency for MovieRemoteDataSourceImpl
class MovieRemoteDataSourceImpl(
        private val tmdbService: TMDBService,
        private val apiKey:String
) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}