package com.huawei.mymovieapplication.data.repository.movie.datasource

import com.huawei.mymovieapplication.data.model.movie.Movie

interface MovieLocalDataSource {

    //we need to get a list of movie instances from the database
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}