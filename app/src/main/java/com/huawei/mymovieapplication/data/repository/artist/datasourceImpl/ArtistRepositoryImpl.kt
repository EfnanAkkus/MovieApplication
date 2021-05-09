package com.huawei.mymovieapplication.data.repository.artist.datasourceImpl

import android.util.Log
import com.huawei.mymovieapplication.data.model.artist.Artist
import com.huawei.mymovieapplication.data.model.artist.ArtistList
import com.huawei.mymovieapplication.data.model.movie.Movie
import com.huawei.mymovieapplication.data.model.movie.MovieList
import com.huawei.mymovieapplication.data.repository.artist.datasource.ArtistCacheDataSource
import com.huawei.mymovieapplication.data.repository.artist.datasource.ArtistLocalDataSource
import com.huawei.mymovieapplication.data.repository.artist.datasource.ArtistRemoteDataSource
import com.huawei.mymovieapplication.domain.repository.ArtistsRepository
import retrofit2.Response
import java.lang.Exception

class ArtistRepositoryImpl(private val artistRemoteDatasource: ArtistRemoteDataSource,
                           private val artistLocalDataSource: ArtistLocalDataSource,
                           private val artistCacheDataSource: ArtistCacheDataSource) : ArtistsRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists:List<Artist> = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            //we will write the codes to get the data from api inside this
            val response: Response<ArtistList> = artistRemoteDatasource.getArtists()
            val body: ArtistList? = response.body()
            if (body != null) {
                //if the response body is avaible, we can write codes to get the list of movies using movies property of it
                //which holds a list of movies
                artistList = body.artists

            }

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        return artistList
        //we will assign the movies taken from the api to the list and we will return it
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (artistList.size > 0) {
            //if movieList.size>0 that means movie data available in the database
            return artistList
        } else {
//if there is no movie data available in the database
            //we need to take them from the rest api and save them to the database
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList

    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (artistList.size > 0) {
            //if movieList.size>0 that means movie data available in the database
            return artistList
        } else {
//if there is no movie data available in the database
            //we need to take them from the rest api and save them to the database
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }



}