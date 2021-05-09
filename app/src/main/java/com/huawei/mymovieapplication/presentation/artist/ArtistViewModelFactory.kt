package com.huawei.mymovieapplication.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.huawei.mymovieapplication.domain.usecase.GetArtistsUsecase
import com.huawei.mymovieapplication.domain.usecase.UpdateArtistsUsecase

class ArtistViewModelFactory(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistsUsecase: UpdateArtistsUsecase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("Not yet implemented")
    }

}