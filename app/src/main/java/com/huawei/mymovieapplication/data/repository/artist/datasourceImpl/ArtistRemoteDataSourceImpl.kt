package com.huawei.mymovieapplication.data.repository.artist.datasourceImpl

import com.huawei.mymovieapplication.data.api.TMDBService
import com.huawei.mymovieapplication.data.model.artist.ArtistList
import com.huawei.mymovieapplication.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey: String) : ArtistRemoteDataSource {


    override suspend fun getArtists(): Response<ArtistList>  = tmdbService.getPopularArtist(apiKey)
}