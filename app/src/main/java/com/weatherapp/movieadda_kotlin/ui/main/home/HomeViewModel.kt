package com.weatherapp.movieadda_kotlin.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingMovies
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingPerson
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingTvShow
import com.weatherapp.movieadda_kotlin.data.pojo.home.UpcomingMovies
import com.weatherapp.movieadda_kotlin.data.repo.trending.TrendingRepository
import com.weatherapp.movieadda_kotlin.data.repo.upcoming.UpcomingRepository

public class HomeViewModel : ViewModel() {

     private var upcoming: UpcomingRepository = UpcomingRepository()
    private lateinit var ucoming_movie:MutableLiveData<UpcomingMovies>

     private  var trerepo: TrendingRepository = TrendingRepository()
     private lateinit var mutable: MutableLiveData<TrendingPerson>
    private lateinit var mutable_movie:MutableLiveData<TrendingMovies>
    private lateinit var mutable_TvShow:MutableLiveData<TrendingTvShow>

    fun getTrending():LiveData<TrendingPerson> {

        if (this::mutable.isInitialized) {
            return mutable
        }
        else{
            mutable = trerepo.getTrendingPerson()
            return mutable
        }
    }

    fun getTrendingMovie():LiveData<TrendingMovies>{

        if (this::mutable_movie.isInitialized){
            return mutable_movie
        }
        else{
            mutable_movie = trerepo.getTrendingMovies()
            return mutable_movie
        }
    }

    fun getTrendingTvShow():LiveData<TrendingTvShow>{

        if (this::mutable_TvShow.isInitialized){
            return mutable_TvShow
        }
        else{
            mutable_TvShow = trerepo.getTrendingTvShow()
            return mutable_TvShow
        }
    }

    fun getUpcomingMovies():LiveData<UpcomingMovies>{

        if (this::ucoming_movie.isInitialized){
            return ucoming_movie
        }
        else{
            ucoming_movie = upcoming.getUpcomingMovies()
            return ucoming_movie
        }
    }
}