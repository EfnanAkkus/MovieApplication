package com.huawei.mymovieapplication.domain.usecase

import com.huawei.mymovieapplication.data.model.movie.Movie
import com.huawei.mymovieapplication.domain.repository.MovieRepository


//use case class cannot return list of movies without getting support from a repository. So we need a
//repository which have a function returns a list of movie instances to inject an instance of that repository
//to the use case class as a constructure parameter
//before start coding inside the use case class, lets create repository interface for it
class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    //After creating MovieRepository interface we can add a repository instance as a constructor parameter
    //(private val movieRepository: MovieRepository) Object type is MovieRepository
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
    //viewmodel class can call to this usecase function to get a list of movies

}