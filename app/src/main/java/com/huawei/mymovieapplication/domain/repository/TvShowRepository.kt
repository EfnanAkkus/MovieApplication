package com.huawei.mymovieapplication.domain.repository

import com.huawei.mymovieapplication.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}