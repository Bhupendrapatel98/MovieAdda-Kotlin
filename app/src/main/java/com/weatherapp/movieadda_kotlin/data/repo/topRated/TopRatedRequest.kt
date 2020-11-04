package com.weatherapp.movieadda_kotlin.data.repo.topRated

import com.weatherapp.movieadda_kotlin.data.pojo.home.PopularMovie
import com.weatherapp.movieadda_kotlin.data.pojo.home.TopRatedMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TopRatedRequest {

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") api_key: String?
    ): Call<TopRatedMovies>
}