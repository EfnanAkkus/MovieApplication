package com.huawei.mymovieapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.huawei.mymovieapplication.data.model.artist.Artist
import com.huawei.mymovieapplication.data.model.movie.Movie
import com.huawei.mymovieapplication.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
        version = 1,
        exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    //we need to define abstract functions to get dao interfaces
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}