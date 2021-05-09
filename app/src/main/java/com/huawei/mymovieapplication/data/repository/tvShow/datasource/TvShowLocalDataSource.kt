package com.huawei.mymovieapplication.data.repository.tvShow.datasource

import com.huawei.mymovieapplication.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    //we need to get a list of movie instances from the database
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(movies:List<TvShow>)
    suspend fun clearAll()
}