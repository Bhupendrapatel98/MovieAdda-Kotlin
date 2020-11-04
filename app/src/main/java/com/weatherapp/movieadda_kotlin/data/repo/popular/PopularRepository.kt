package com.weatherapp.movieadda_kotlin.data.repo.popular

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weatherapp.movieadda_kotlin.data.pojo.home.PopularMovie
import com.weatherapp.movieadda_kotlin.data.pojo.home.UpcomingMovies
import com.weatherapp.movieadda_kotlin.data.repo.upcoming.GetUpcomingRequest
import com.weatherapp.movieadda_kotlin.data.utils.Constant
import com.weatherapp.movieadda_kotlin.data.utils.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularRepository {

    fun getPopularMovies(): MutableLiveData<PopularMovie> {

        val getPopular: MutableLiveData<PopularMovie> = MutableLiveData()

        RetrofitClint.getRetrofitClint(Constant.BASE_URL)
            .create(GetPopularRequest::class.java)
            .getPopularMovies(Constant.key)
            .enqueue(object : Callback<PopularMovie> {

                override fun onResponse(
                    call: Call<PopularMovie>,
                    response: Response<PopularMovie>
                ) {
                    getPopular.postValue(response.body())
                }

                override fun onFailure(call: Call<PopularMovie>, t: Throwable) {

                }

            })
        return getPopular
    }
}