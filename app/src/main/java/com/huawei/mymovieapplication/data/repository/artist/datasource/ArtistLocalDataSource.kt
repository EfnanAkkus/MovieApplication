package com.huawei.mymovieapplication.data.repository.artist.datasource

import com.huawei.mymovieapplication.data.model.artist.Artist

interface ArtistLocalDataSource {
    //we need to get a list of Artist instances from the database
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(movies:List<Artist>)
    suspend fun clearAll()
}