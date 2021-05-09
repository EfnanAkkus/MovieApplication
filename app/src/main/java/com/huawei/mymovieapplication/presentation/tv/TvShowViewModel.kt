package com.huawei.mymovieapplication.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.huawei.mymovieapplication.domain.usecase.GetTvShowsUsecase
import com.huawei.mymovieapplication.domain.usecase.UpdateTvShowsUsecase

class TvShowViewModel(
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
):ViewModel() {

    fun getTvShow()= liveData {
        val tvShowList=getTvShowsUsecase.execute()
        emit(tvShowList)
    }

    fun updateTvShow()= liveData {
        val tvShowList=updateTvShowsUsecase.execute()
        emit(tvShowList)
    }
}