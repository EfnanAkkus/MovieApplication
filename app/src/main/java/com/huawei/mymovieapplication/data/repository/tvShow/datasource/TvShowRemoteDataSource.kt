package com.huawei.mymovieapplication.data.repository.tvShow.datasource

import com.huawei.mymovieapplication.data.model.movie.MovieList
import com.huawei.mymovieapplication.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>

}