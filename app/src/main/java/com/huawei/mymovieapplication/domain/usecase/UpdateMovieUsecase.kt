package com.huawei.mymovieapplication.domain.usecase

import com.huawei.mymovieapplication.data.model.movie.Movie
import com.huawei.mymovieapplication.domain.repository.MovieRepository

//this use case should be able to command to update the room database movie table using the latest data
//taken from the api and get a list of new movies as a return value
class UpdateMovieUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}