package com.weatherapp.movieadda_kotlin.data.repo.upcoming

import com.weatherapp.movieadda_kotlin.data.pojo.home.UpcomingMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetUpcomingRequest {

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") api_key: String?
    ): Call<UpcomingMovies>
}