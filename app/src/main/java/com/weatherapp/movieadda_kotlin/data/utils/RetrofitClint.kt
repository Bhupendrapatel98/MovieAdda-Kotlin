package com.weatherapp.movieadda_kotlin.data.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClint {

    companion object {

        lateinit var retrofit: Retrofit

        fun getRetrofitClint(s: String): Retrofit {

            if (this::retrofit.isInitialized) {
                return retrofit
            } else {
                retrofit = Retrofit.Builder()
                    .baseUrl(s)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofit
            }
        }

    }

}