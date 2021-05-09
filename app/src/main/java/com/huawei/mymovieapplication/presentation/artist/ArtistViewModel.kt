package com.huawei.mymovieapplication.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.huawei.mymovieapplication.domain.usecase.GetArtistsUsecase
import com.huawei.mymovieapplication.domain.usecase.UpdateArtistsUsecase

class ArtistViewModel(
    private val getArtistsUseCase:GetArtistsUsecase,
    private val updateArtistsUsecase: UpdateArtistsUsecase
):ViewModel() {
    fun getArtists()= liveData {
        val artistList=getArtistsUseCase.execute()
        emit(artistList)
        //emit receive list as livedata since we are using coroutine we will use a livedata block
        //here. we dont provide dispatcher here so coroutine will use the Main thread. Since we have
    }
    fun updateArtists()= liveData {
        val artistList=updateArtistsUsecase.execute()
        emit(artistList)

    }
}