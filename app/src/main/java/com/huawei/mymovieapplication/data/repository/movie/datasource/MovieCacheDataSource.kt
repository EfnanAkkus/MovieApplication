package com.huawei.mymovieapplication.data.repository.movie.datasource

import com.huawei.mymovieapplication.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMovieToCache(movies:List<Movie>)
}