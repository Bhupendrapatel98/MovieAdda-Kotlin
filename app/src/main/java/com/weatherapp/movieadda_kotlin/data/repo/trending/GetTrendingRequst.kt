package com.weatherapp.movieadda_kotlin.data.repo.trending

import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingMovies
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingPerson
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingTvShow
import com.weatherapp.movieadda_kotlin.data.pojo.home.UpcomingMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetTrendingRequst {

    @GET("trending/{media_type}/{time_window}")
    fun getTrendingPerson(
        @Path("media_type") media_type: String?,
        @Path("time_window") time_window: String?,
        @Query("api_key") api_key: String?
    ): Call<TrendingPerson>

    @GET("trending/{media_type}/{time_window}")
    fun getTrendingMovies(
        @Path("media_type") media_type: String?,
        @Path("time_window") time_window: String?,
        @Query("api_key") api_key: String?
    ): Call<TrendingMovies>

    @GET("trending/{media_type}/{time_window}")
    fun getTrendingTvShow(
        @Path("media_type") media_type: String?,
        @Path("time_window") time_window: String?,
        @Query("api_key") api_key: String?
    ): Call<TrendingTvShow>

}