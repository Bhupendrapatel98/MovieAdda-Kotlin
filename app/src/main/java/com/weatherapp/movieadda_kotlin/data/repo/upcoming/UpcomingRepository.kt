package com.weatherapp.movieadda_kotlin.data.repo.upcoming

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weatherapp.movieadda_kotlin.data.pojo.home.UpcomingMovies
import com.weatherapp.movieadda_kotlin.data.utils.Constant
import com.weatherapp.movieadda_kotlin.data.utils.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingRepository {

    fun getUpcomingMovies():MutableLiveData<UpcomingMovies>{

        val getUpcoming:MutableLiveData<UpcomingMovies> = MutableLiveData()

        RetrofitClint.getRetrofitClint(Constant.BASE_URL)
            .create(GetUpcomingRequest::class.java)
            .getUpcomingMovies(Constant.key)
            .enqueue(object : Callback<UpcomingMovies> {

                override fun onResponse(
                    call: Call<UpcomingMovies>,
                    response: Response<UpcomingMovies>
                ) {
                    Log.d("dmhbsdjhdf", "onResponse: "+response)
                    Log.d("dmhbsdjhdf", "onResponse: " + response.body())
                    getUpcoming.postValue(response.body())
                }

                override fun onFailure(call: Call<UpcomingMovies>, t: Throwable) {

                }

            })
        return getUpcoming
    }
}