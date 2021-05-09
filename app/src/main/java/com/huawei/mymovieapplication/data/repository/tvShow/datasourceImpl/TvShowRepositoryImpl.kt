package com.huawei.mymovieapplication.data.repository.tvShow.datasourceImpl

import android.util.Log
import com.huawei.mymovieapplication.data.model.tvshow.TvShow
import com.huawei.mymovieapplication.data.model.tvshow.TvShowList
import com.huawei.mymovieapplication.data.repository.tvShow.datasource.TvShowCacheDataSource
import com.huawei.mymovieapplication.data.repository.tvShow.datasource.TvShowLocalDataSource
import com.huawei.mymovieapplication.data.repository.tvShow.datasource.TvShowRemoteDataSource
import com.huawei.mymovieapplication.domain.repository.TvShowRepository
import retrofit2.Response
import java.lang.Exception

class TvShowRepositoryImpl(private val tvShowRemoteDatasource: TvShowRemoteDataSource,
                           private val tvShowLocalDataSource: TvShowLocalDataSource,
                           private val tvShowCacheDataSource: TvShowCacheDataSource) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow: List<TvShow> = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            //we will write the codes to get the data from api inside this
            val response: Response<TvShowList> = tvShowRemoteDatasource.getTvShows()
            val body: TvShowList? = response.body()
            if (body != null) {
                //if the response body is avaible, we can write codes to get the list of movies using movies property of it
                //which holds a list of movies
                tvShowList = body.tvShows

            }

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        return tvShowList
        //we will assign the movies taken from the api to the list and we will return it
    }

    suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            //if movieList.size>0 that means movie data available in the database
            return tvShowList
        } else {
//if there is no movie data available in the database
            //we need to take them from the rest api and save them to the database
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)

        }
        return tvShowList

    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()

        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            //if movieList.size>0 that means movie data available in the database
            return tvShowList
        } else {
//if there is no movie data available in the database
            //we need to take them from the rest api and save them to the database
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}