package com.huawei.mymovieapplication.data.api

import com.huawei.mymovieapplication.data.model.artist.ArtistList
import com.huawei.mymovieapplication.data.model.movie.MovieList
import com.huawei.mymovieapplication.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//tmmdb api'si movie datasını bize MovieList class'ının objesi olarak gönderiyor
//suspending olarak tanımlamamızın sebebi background process için kotlin Coroutine kullanmamız
interface TMDBService {
    //bu fonksiyonun(getPopularMovies()) return tipi MovieList'in retrofit response objesi olmalıdır
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String):Response<MovieList>
    //Query parametresini dahil edebilmek için query annotation'ı kullandık. Bu propert'nin api_name'ini
    //query annotation'ı ile birlikte eklememiz gerekir

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apiKey:String):Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key")apiKey:String):Response<ArtistList>
}