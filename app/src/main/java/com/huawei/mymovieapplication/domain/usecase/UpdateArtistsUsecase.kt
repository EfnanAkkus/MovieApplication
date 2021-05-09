package com.huawei.mymovieapplication.domain.usecase

import com.huawei.mymovieapplication.data.model.artist.Artist
import com.huawei.mymovieapplication.domain.repository.ArtistsRepository

class UpdateArtistsUsecase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute():List<Artist>?=artistsRepository.updateArtists()
}