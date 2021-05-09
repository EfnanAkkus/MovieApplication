package com.huawei.mymovieapplication.presentation.di

import com.huawei.mymovieapplication.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/*ın order to get data from the TMDB web api, we need an instance of TMDBService.
To construct a TMDB instance we need a Retrofit instance */
@Module
class NetModule(private val baseUrl: String) {
    //to create a retrofit instance we need to provide  the base url

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        //provideRetrofit function return type should be retrofit
        //here we will construct a retrofit instance using its builder function call and return it
        //TMDB api send us data in JSON format. To convert JSON to Kotlin. we need a converter factory

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): TMDBService {
        //return type should be TMDBService This function needs an instance of retrofit as a dependency
        return retrofit.create(TMDBService::class.java)

    }
}