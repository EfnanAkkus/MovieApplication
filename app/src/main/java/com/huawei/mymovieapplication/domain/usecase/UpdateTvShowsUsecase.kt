package com.huawei.mymovieapplication.domain.usecase

import com.huawei.mymovieapplication.data.model.tvshow.TvShow
import com.huawei.mymovieapplication.domain.repository.TvShowRepository

class UpdateTvShowsUsecase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}