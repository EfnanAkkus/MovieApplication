package com.huawei.mymovieapplication.domain.repository

import com.huawei.mymovieapplication.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}