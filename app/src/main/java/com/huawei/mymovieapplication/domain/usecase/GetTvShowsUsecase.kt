package com.huawei.mymovieapplication.domain.usecase

import com.huawei.mymovieapplication.data.model.tvshow.TvShow
import com.huawei.mymovieapplication.domain.repository.TvShowRepository

class GetTvShowsUsecase(private val tvShowsRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowsRepository.getTvShows()
}