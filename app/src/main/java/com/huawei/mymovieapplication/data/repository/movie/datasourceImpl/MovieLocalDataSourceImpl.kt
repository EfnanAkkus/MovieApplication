package com.huawei.mymovieapplication.data.repository.movie.datasourceImpl

import com.huawei.mymovieapplication.data.db.MovieDao
import com.huawei.mymovieapplication.data.model.movie.Movie
import com.huawei.mymovieapplication.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    //when we are getting data from the room database, room execute that query in a background thread.
//we dont need to write codes for background processing. we need to invoke other dao functions from background thread
//we will use coroutine for that
    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}