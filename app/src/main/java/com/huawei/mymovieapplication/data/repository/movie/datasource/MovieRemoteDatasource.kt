package com.huawei.mymovieapplication.data.repository.movie.datasource

import com.huawei.mymovieapplication.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}