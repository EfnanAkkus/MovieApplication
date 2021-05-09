package com.huawei.mymovieapplication.data.repository.artist.datasource

import com.huawei.mymovieapplication.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(movies:List<Artist>)
}