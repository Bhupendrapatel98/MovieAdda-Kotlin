package com.weatherapp.movieadda_kotlin.data.repo.topRated

import androidx.lifecycle.MutableLiveData
import com.weatherapp.movieadda_kotlin.data.pojo.home.PopularMovie
import com.weatherapp.movieadda_kotlin.data.pojo.home.TopRatedMovies
import com.weatherapp.movieadda_kotlin.data.repo.popular.GetPopularRequest
import com.weatherapp.movieadda_kotlin.data.utils.Constant
import com.weatherapp.movieadda_kotlin.data.utils.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedRepository {

    fun getTopratedMovies(): MutableLiveData<TopRatedMovies> {

        val getTopRated: MutableLiveData<TopRatedMovies> = MutableLiveData()

        RetrofitClint.getRetrofitClint(Constant.BASE_URL)
            .create(TopRatedRequest::class.java)
            .getTopRatedMovies(Constant.key)
            .enqueue(object : Callback<TopRatedMovies> {

                override fun onResponse(
                    call: Call<TopRatedMovies>,
                    response: Response<TopRatedMovies>
                ) {
                    getTopRated.postValue(response.body())
                }

                override fun onFailure(call: Call<TopRatedMovies>, t: Throwable) {

                }

            })
        return getTopRated
    }
}