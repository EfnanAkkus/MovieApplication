package com.huawei.mymovieapplication.data.model.tvshow


import com.google.gson.annotations.SerializedName
import com.huawei.mymovieapplication.data.model.tvshow.TvShow

data class TvShowList(

        @SerializedName("results")
    val tvShows: List<TvShow>

)