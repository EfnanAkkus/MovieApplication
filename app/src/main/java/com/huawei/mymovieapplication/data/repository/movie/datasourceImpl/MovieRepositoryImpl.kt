package com.huawei.mymovieapplication.data.repository.movie.datasourceImpl

import android.util.Log
import com.huawei.mymovieapplication.data.model.movie.Movie
import com.huawei.mymovieapplication.data.model.movie.MovieList
import com.huawei.mymovieapplication.data.repository.movie.datasource.MovieCacheDataSource
import com.huawei.mymovieapplication.data.repository.movie.datasource.MovieLocalDataSource
import com.huawei.mymovieapplication.data.repository.movie.datasource.MovieRemoteDatasource
import com.huawei.mymovieapplication.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(private val movieRemoteDatasource: MovieRemoteDatasource,
                          private val movieLocalDataSource: MovieLocalDataSource,
                          private val movieCacheDataSource: MovieCacheDataSource) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        //return a list of movie instance
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        //update the database with latest popular movies taken from the api and return that new list of movie instance
        //when the user views the movie data for the first time , app will download them from the TMDB Apı
        //TMDB Apı will sent us the first 20 movies in the most popular list
       //update movies we need to get movie data from the web api first
        val newListOfMovies:List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)
        return newListOfMovies

    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            //we will write the codes to get the data from api inside this
            val response: Response<MovieList> = movieRemoteDatasource.getMovies()
            val body: MovieList? = response.body()
            if (body != null) {
                //if the response body is avaible, we can write codes to get the list of movies using movies property of it
                //which holds a list of movies
                movieList = body.movies

            }

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        return movieList
        //we will assign the movies taken from the api to the list and we will return it
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (movieList.size > 0) {
            //if movieList.size>0 that means movie data available in the database
            return movieList
        } else {
//if there is no movie data available in the database
            //we need to take them from the rest api and save them to the database
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)

        }
        return movieList

    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (movieList.size > 0) {
            //if movieList.size>0 that means movie data available in the database
            return movieList
        } else {
//if there is no movie data available in the database
            //we need to take them from the rest api and save them to the database
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }
        return movieList
    }
}