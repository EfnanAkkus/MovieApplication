package com.huawei.mymovieapplication.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.huawei.mymovieapplication.domain.usecase.GetMoviesUseCase
import com.huawei.mymovieapplication.domain.usecase.UpdateMovieUsecase

//we need to add an instance of GetMoviesUseCase and an instance of UpdateMoviesUseCase as constructure parameter
class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUsecase: UpdateMovieUsecase
) : ViewModel() {
//this function will invoke execute function of the getMoviesUseCase and emit received list as livedata
// we dont provide dispatcher here coroutine will use the Main thread. Since we use IO thread in the data sources
// calling them from the UI thread

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUsecase.execute()
        emit(movieList)
    }

}