package com.huawei.mymovieapplication.presentation.di

import android.content.Context
import androidx.room.Room
import com.huawei.mymovieapplication.data.db.ArtistDao
import com.huawei.mymovieapplication.data.db.MovieDao
import com.huawei.mymovieapplication.data.db.TMDBDatabase
import com.huawei.mymovieapplication.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    /*we need to pass the context. Inside the app module we will write a provider function to provide
     the application context*/

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }
    /*In this project we have 3 DAO interfaces. Local data source classes need them as dependencies*/
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }
    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return tmdbDatabase.tvShowDao()
    }
//in our project datasources are dependencies for repositories
}