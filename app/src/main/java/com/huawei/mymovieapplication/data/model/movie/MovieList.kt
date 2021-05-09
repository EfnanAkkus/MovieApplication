package com.huawei.mymovieapplication.data.model.movie


import com.google.gson.annotations.SerializedName
import com.huawei.mymovieapplication.data.model.movie.Movie

data class MovieList(

        @SerializedName("results")
    val movies: List<Movie>

)