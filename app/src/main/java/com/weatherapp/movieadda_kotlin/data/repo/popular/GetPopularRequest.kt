package com.weatherapp.movieadda_kotlin.data.repo.popular

import com.weatherapp.movieadda_kotlin.data.pojo.home.PopularMovie
import com.weatherapp.movieadda_kotlin.data.pojo.home.UpcomingMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetPopularRequest {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") api_key: String?
    ): Call<PopularMovie>

}