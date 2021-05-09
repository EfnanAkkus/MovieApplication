package com.huawei.mymovieapplication.data.repository.artist.datasource

import com.huawei.mymovieapplication.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>

}