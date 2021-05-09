package com.huawei.mymovieapplication.data.repository.tvShow.datasource

import com.huawei.mymovieapplication.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(movies:List<TvShow>)
}