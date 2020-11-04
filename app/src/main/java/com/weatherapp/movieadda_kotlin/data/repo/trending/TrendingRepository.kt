package com.weatherapp.movieadda_kotlin.data.repo.trending

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingMovies
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingPerson
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingTvShow
import com.weatherapp.movieadda_kotlin.data.utils.Constant
import com.weatherapp.movieadda_kotlin.data.utils.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TrendingRepository {

    fun getTrendingPerson(): MutableLiveData<TrendingPerson> {

        val getTre: MutableLiveData<TrendingPerson> = MutableLiveData()

        RetrofitClint.getRetrofitClint(Constant.BASE_URL)
            .create(GetTrendingRequst::class.java)
            .getTrendingPerson("person", "week", Constant.key)
            .enqueue(object : Callback<TrendingPerson> {

                override fun onResponse(
                    call: Call<TrendingPerson>,
                    response: Response<TrendingPerson>
                ) {
                    getTre.postValue(response.body())
                }
                override fun onFailure(call: Call<TrendingPerson>, t: Throwable) {

                }
            })

        return getTre
    }

    fun getTrendingMovies():MutableLiveData<TrendingMovies>{

        val getTreMovie : MutableLiveData<TrendingMovies> = MutableLiveData()

        RetrofitClint.getRetrofitClint(Constant.BASE_URL)
            .create(GetTrendingRequst::class.java)
            .getTrendingMovies("movie","week",Constant.key)
            .enqueue(object : Callback<TrendingMovies> {

                override fun onResponse(
                    call: Call<TrendingMovies>,
                    response: Response<TrendingMovies>
                ) {
                    getTreMovie.postValue(response.body())
                }

                override fun onFailure(call: Call<TrendingMovies>, t: Throwable) {

                }

            })
        return getTreMovie
    }

    fun getTrendingTvShow():MutableLiveData<TrendingTvShow>{

        val getTreTvShow : MutableLiveData<TrendingTvShow> = MutableLiveData()

        RetrofitClint.getRetrofitClint(Constant.BASE_URL)
            .create(GetTrendingRequst::class.java)
            .getTrendingTvShow("tv","day",Constant.key)
            .enqueue(object : Callback<TrendingTvShow> {

                override fun onResponse(
                    call: Call<TrendingTvShow>,
                    response: Response<TrendingTvShow>
                ) {
                    getTreTvShow.postValue(response.body())
                }

                override fun onFailure(call: Call<TrendingTvShow>, t: Throwable) {

                }

            })
        return getTreTvShow
    }
}
