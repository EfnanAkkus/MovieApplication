package com.huawei.mymovieapplication.domain.repository

import com.huawei.mymovieapplication.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    //use the same repository for both of movie use cases
    suspend fun updateMovies():List<Movie>?

}