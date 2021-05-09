package com.huawei.mymovieapplication.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.huawei.mymovieapplication.domain.usecase.GetMoviesUseCase
import com.huawei.mymovieapplication.domain.usecase.UpdateMovieUsecase

//we need MovieViewModelFactory for MovieViewModel class
class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUsecase: UpdateMovieUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMovieUsecase) as T
    }


}
